package com.company.customerdataservice.repository;
import com.company.customerdataservice.controller.CustomerController;
import com.company.customerdataservice.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerRepositoryTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        customerRepository.deleteAll();
    }

    @Test
    public void shouldCreateCustomer()throws Exception {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Joe");
        customer1.setLastName("Doe");
        customer1.setCity("Alberta");
        customer1.setPhone("201-456-8879");
        customer1.setCompany("Verizon");
        customer1.setState("New York");
        customer1.setPostalCode("54678");
        customer1.setAddress1("150 Pure Life");
        customer1.setAddress2("205 Poland Spring");
        customer1.setCountry("United States of America");
        customer1.setEmail("freshwater@river.com");

//      save the customers using 'POST /customers' endpoint
        customerRepository.save(customer1);

        String inputJson = mapper.writeValueAsString(customer1);

        mockMvc.perform(post("/customers").content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(42);
        customer.setAddress1("1800 Panda Express");
        customer.setAddress2("1801  Takeout");
        customer.setCity("Brooklyn");
        customer.setCompany("Walmart");
        customer.setCountry("United States");
        customer.setPostalCode("07087");
        customer.setEmail("panda23@express.com");
        customer.setFirstName("Lo");
        customer.setLastName("Mein");
        customer.setState("New York");
        customer.setPhone("123-654-0987");

        customerRepository.save(customer);

        customer.setLastName("Orange");

//     save the updated customer using 'put /customers' endpoint
       customerRepository.save(customer);

       String inputJson = mapper.writeValueAsString(customer);
       mockMvc.perform(put("/customers")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(inputJson))
               .andDo(print())
               .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        Customer customer2 = new Customer();
        customer2.setId(1);
        customer2.setFirstName("Petunia");
        customer2.setLastName("Orchid");
        customer2.setEmail("flowers@allyearlong.org");
        customer2.setPostalCode("07058");
        customer2.setState("Georgia");
        customer2.setCountry("United States of America");
        customer2.setCity("Atlanta");
        customer2.setPhone("201-723-3456");
        customer2.setAddress1("124 Flower Lane");
        customer2.setAddress2("136 Flower Ave");
        customer2.setCompany("Botanical Museum");

        customerRepository.save(customer2);

//      save the customer and then use 'delete /customers' endpoint
        mockMvc.perform(delete("/customers/{id}", customer2.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetCustomerById() throws Exception {
        Customer customer3 = new Customer();
        customer3.setId(32);
        customer3.setCompany("Google");
        customer3.setAddress1("300 Google Lane");
        customer3.setAddress2("440 Google Ave");
        customer3.setCity("Seatle");
        customer3.setState("Washington");
        customer3.setPhone("1-800-987-234");
        customer3.setCountry("United States of America");
        customer3.setEmail("newgoogly@google.com");
        customer3.setFirstName("Practice");
        customer3.setLastName("Makes Perfect");
        customer3.setPostalCode("73245");

//      save the customer and then find with the id using the get
        customerRepository.save(customer3);
        mockMvc.perform(get("/customers/{id}", customer3.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomerByState() throws Exception {
        Customer customer4 = new Customer();
        customer4.setId(64);
        customer4.setCompany("Avalon");
        customer4.setAddress1("500 Plant Tree");
        customer4.setAddress2("560 Laughter Ave");
        customer4.setCity("Trenton");
        customer4.setState("New Jersey");
        customer4.setPhone("1-810-310-4567");
        customer4.setCountry("United States of America");
        customer4.setEmail("climate@time.com");
        customer4.setFirstName("Jessica");
        customer4.setLastName("Mayhem");
        customer4.setPostalCode("26789");

//      save the customer and then find with the state using the get
        customerRepository.save(customer4);
        mockMvc.perform(get("/customers/state/{state}", customer4.getState()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

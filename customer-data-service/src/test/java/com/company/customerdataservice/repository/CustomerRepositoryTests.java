package com.company.customerdataservice.repository;
import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerRepositoryTests {
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    // test makes sures the customer is saved in repository and retrieves the details
    @Test
    public void shouldCreateNewCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setPostalCode("75436");
        newCustomer.setLastName("Lavendar");
        newCustomer.setFirstName("Bob");
        newCustomer.setEmail("lavendarbob@gmail.com");
        newCustomer.setCountry("USA");
        newCustomer.setCity("Dallas");
        newCustomer.setState("Texas");
        newCustomer.setPhone("315-670-7658");
        newCustomer.setCompany("Amazon");
        newCustomer.setAddress1("Lavendar Tree Ave");
        newCustomer.setAddress2("Petunia Wilderness Lane");

        newCustomer = customerRepository.save(newCustomer);

        Optional<Customer> getCustomer = customerRepository.findById(newCustomer.getId());
        assertEquals(getCustomer.get(), newCustomer);
    }

    // tests makes sures the customer gets updated and retrieved with the details
    @Test
    public void shouldUpdateCustomer() {
        Customer updatedCustomer = new Customer();
        updatedCustomer.setPostalCode("12345");
        updatedCustomer.setLastName("Build");
        updatedCustomer.setFirstName("Bob");
        updatedCustomer.setEmail("builder@gmail.com");
        updatedCustomer.setCountry("USA");
        updatedCustomer.setCity("Houston");
        updatedCustomer.setState("Dallas");
        updatedCustomer.setPhone("315-680-7648");
        updatedCustomer.setCompany("Forever 21");
        updatedCustomer.setAddress1("Builder House Ave");
        updatedCustomer.setAddress2("Bob Wilderness Lane");

        customerRepository.save(updatedCustomer);
        updatedCustomer.setCompany("Verizon");
        customerRepository.save(updatedCustomer);

        Optional<Customer> customer1 = customerRepository.findById(updatedCustomer.getId());
        assertEquals(customer1.get(), updatedCustomer);
    }

    // tests makes sures the customer get deleted and nothing appears
    @Test
    public void shouldDeleteCustomer() {
        Customer deleteCustomer = new Customer();
        deleteCustomer.setPostalCode("12345");
        deleteCustomer.setLastName("Patty");
        deleteCustomer.setFirstName("Summer");
        deleteCustomer.setEmail("summertime@gmail.com");
        deleteCustomer.setCountry("USA");
        deleteCustomer.setCity("West Palm Beach");
        deleteCustomer.setState("Florida");
        deleteCustomer.setPhone("315-312-5467");
        deleteCustomer.setCompany("Netflix");
        deleteCustomer.setAddress1("Production Ave");
        deleteCustomer.setAddress2("Hollywood Lane");
        deleteCustomer.setId(21);

        deleteCustomer = customerRepository.save(deleteCustomer);

        Optional<Customer> deleteCustomer1 = customerRepository.findById(deleteCustomer.getId());

        assertEquals(deleteCustomer1.get(), deleteCustomer);

        customerRepository.deleteById(deleteCustomer.getId());

        deleteCustomer1 = customerRepository.findById(deleteCustomer.getId());

        assertFalse(deleteCustomer1.isPresent());
    }

    // test makes sures the customer can be grabbed by id
    @Test
    public void shouldGetCustomerById() {
        Customer getCustomerId = new Customer();
        getCustomerId.setPostalCode("56789");
        getCustomerId.setLastName("Cullen");
        getCustomerId.setFirstName("Violet");
        getCustomerId.setEmail("twilight@gmail.com");
        getCustomerId.setCountry("USA");
        getCustomerId.setCity("Phoenix");
        getCustomerId.setState("Arizona");
        getCustomerId.setPhone("123-654-9876");
        getCustomerId.setCompany("Meta");
        getCustomerId.setAddress1("Social Media Ave");
        getCustomerId.setAddress2("Social Lane");
        customerRepository.save(getCustomerId );

        Customer getCustomerId1 = new Customer();
        getCustomerId1.setPostalCode("56789");
        getCustomerId1.setLastName("Perkins");
        getCustomerId1.setFirstName("Stephanie");
        getCustomerId1.setEmail("twilight@gmail.com");
        getCustomerId1.setCountry("USA");
        getCustomerId1.setCity("Atlanta");
        getCustomerId1.setState("Georgia");
        getCustomerId1.setPhone("354-635-1077");
        getCustomerId1.setCompany("Citadel");
        getCustomerId1.setAddress1("Trading Ave");
        getCustomerId1.setAddress2("Fintech Lane");
        customerRepository.save(getCustomerId1);

        Optional<Customer> foundCustomer = customerRepository.findById(getCustomerId.getId());

        assertEquals(foundCustomer.get(), getCustomerId);
    }

    // tests makes sures customers can get grabbed by state
    @Test
    public void shouldGetCustomerByState() {
        Customer getCustomerState = new Customer();
        getCustomerState.setPostalCode("45678");
        getCustomerState.setLastName("Dixie");
        getCustomerState.setFirstName("Hart");
        getCustomerState.setEmail("dixieDr@gmail.com");
        getCustomerState.setCountry("USA");
        getCustomerState.setCity("Phoenix");
        getCustomerState.setState("Arizona");
        getCustomerState.setPhone("123-655-9870");
        getCustomerState.setCompany("Hackensack Medical Hospital");
        getCustomerState.setAddress1("Doctor Village Ave");
        getCustomerState.setAddress2("Nurse Lane");
        getCustomerState.setId(10);

        getCustomerState = customerRepository.save(getCustomerState);

        Customer getCustomerState1 = new Customer();
        getCustomerState1.setPostalCode("34400");
        getCustomerState1.setLastName("Walkins");
        getCustomerState1.setFirstName("Dickens");
        getCustomerState1.setEmail("authorville@gmail.com");
        getCustomerState1.setCountry("USA");
        getCustomerState1.setCity("Phoenix");
        getCustomerState1.setState("Arizona");
        getCustomerState1.setPhone("236-237-9387");
        getCustomerState1.setCompany("Staples");
        getCustomerState1.setAddress1("Paper Town Ave");
        getCustomerState1.setAddress2("Pencil Pane");
        getCustomerState1.setId(6);

        getCustomerState1 = customerRepository.save(getCustomerState1);

        List<Customer> foundCustomers = customerRepository.findByState(getCustomerState.getState());

        assertEquals(foundCustomers.size(), 2);
    }

}

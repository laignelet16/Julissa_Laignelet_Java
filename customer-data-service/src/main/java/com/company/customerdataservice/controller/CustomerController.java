package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;

import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerRepository repo;
    @Autowired
    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

//  endpoint to add a new customer
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

//  endpoint to update a customer
    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

//  endpoint to delete customer
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        repo.deleteById(id);
    }

//  endpoint to find customer with id
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        Optional<Customer> returnValue = repo.findById(id);
        return returnValue.orElse(null);
    }

//  endpoint to find a customer (list of them) with their state
    @GetMapping("/customers/state/{state}")
    public List<Customer> getCustomersByState (@PathVariable String state) {
        Optional<List<Customer>> returnValues = Optional.ofNullable(repo.findByState(state));
        return returnValues.orElse(null);
    }
}

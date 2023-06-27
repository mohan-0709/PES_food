package com.pes_food.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pes_food.model.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private AddCustomerStrategy addCustomerStrategy;
    
    @Autowired
    private UpdateCustomerStrategy updateCustomerStrategy;
    
    @Autowired
    private DeleteCustomerByIdStrategy deleteCustomerByIdStrategy;
    
    @Autowired
    private DeleteCustomerStrategy deleteCustomerStrategy;
    
    @Autowired
    private ViewCustomerStrategy viewCustomerStrategy;
    
    @Autowired
    private ViewAllCustomersStrategy viewAllCustomersStrategy;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return addCustomerStrategy.execute(null, customer);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestParam(required = false) String key, @RequestBody Customer customer) {
        return updateCustomerStrategy.execute(key, key, customer);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@RequestParam(required = false) String key, @PathVariable("id") Integer customerId) {
        return deleteCustomerByIdStrategy.execute(key, customerId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Customer> deleteCustomer(@RequestParam(required = false) String key, @RequestBody Customer customer) {
        return deleteCustomerStrategy.execute(key, customer);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Customer> viewCutomer(@RequestParam(required = false) String key, @PathVariable("id") Integer id) {
        return viewCustomerStrategy.execute(key, id);
    }

    @GetMapping("/all")
    public ResponseEntity<Customer> viewAllCustomers(@RequestParam(required = false) String key) {
        return viewAllCustomersStrategy.execute(key);
    }
}
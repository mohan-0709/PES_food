package com.pes_food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.pes_food.exception.CustomerException;
import com.pes_food.exception.LoginException;
import com.pes_food.model.Customer;
import com.pes_food.service.CustomerService;


public interface CustomerStrategy {
    ResponseEntity<Customer> execute(String key, Object... args) throws CustomerException, LoginException;
}

@Component
class AddCustomerStrategy implements CustomerStrategy {
    @Autowired
    private CustomerService customerService;
    
    @Override
    public ResponseEntity<Customer> execute(String key, Object... args) {
        try {
            Customer customer = (Customer) args[0];
            Customer returnCustomer = customerService.addCustomer(customer);
            return new ResponseEntity<Customer>(returnCustomer, HttpStatus.CREATED);
        } catch (CustomerException e) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
    }
}

@Component
class UpdateCustomerStrategy implements CustomerStrategy {
    @Autowired
    private CustomerService customerService;
    
    @Override
    public ResponseEntity<Customer> execute(String key, Object... args) {
        try {
            String updateKey = (String) args[0];
            Customer customer = (Customer) args[1];
            Customer returnCustomer = customerService.updateCustomer(updateKey, customer);
            return new ResponseEntity<Customer>(returnCustomer, HttpStatus.OK);
        } catch (CustomerException | LoginException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

@Component
 class DeleteCustomerByIdStrategy implements CustomerStrategy {
    @Autowired
    private CustomerService customerService;
    
    @Override
    public ResponseEntity<Customer> execute(String key, Object... args) {
        try {
            String deleteKey = (String) args[0];
            Integer customerId = (Integer) args[1];
            Customer customer = customerService.removeCustomerById(deleteKey, customerId);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } catch (CustomerException | LoginException e) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
    }
}

@Component
 class DeleteCustomerStrategy implements CustomerStrategy {
    @Autowired
    private CustomerService customerService;
    
    @Override
    public ResponseEntity<Customer> execute(String key, Object... args) {
        try {
            String deleteKey = (String) args[0];
            Customer customer = (Customer) args[1];
            Customer resCustomer = customerService.removeCustomer(deleteKey, customer);
            return new ResponseEntity<Customer>(resCustomer, HttpStatus.OK);
        } catch (CustomerException | LoginException e) {
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
    }
}

@Component
 class ViewCustomerStrategy implements CustomerStrategy {
    @Autowired
    private CustomerService customerService;
    
    @Override
    public ResponseEntity<Customer> execute(String key, Object... args) {
        try {
            String viewKey = (String) args[0];
            Integer customerId = (Integer) args[1];
            Customer customer = customerService.viewCustomer(viewKey, customerId);
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        } catch (CustomerException | LoginException e) {
            return new ResponseEntity<Customer>( HttpStatus.BAD_REQUEST);
        }
    }
}

@Component
class ViewAllCustomersStrategy implements CustomerStrategy {
    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<Customer> execute(String key, Object... args) {
        try {
            String viewAllKey = (String) args[0];
            List<Customer> customers = customerService.viewAllCustomers(viewAllKey);
            Customer customer = customers.get(0); // get the first customer from the list
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (CustomerException | LoginException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
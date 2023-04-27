package com.pes_food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pes_food.exception.CustomerException;
import com.pes_food.exception.LoginException;
import com.pes_food.model.CurrentUserSession;
import com.pes_food.model.Customer;
import com.pes_food.model.FoodCart;
import com.pes_food.repository.CurrentUserSessionRepo;
import com.pes_food.repository.CustomerRepo;
import com.pes_food.repository.FoodCartRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private FoodCartRepo foodCartRepo;

	@Autowired
	private CurrentUserSessionRepo currSession;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {

		Customer existsCustomer = customerRepo.findByEmail(customer.getEmail());

		if (existsCustomer != null) {
			throw new CustomerException("Customer email alreday exists!");
		} else {

			FoodCart foodCart = new FoodCart();
			foodCartRepo.save(foodCart);
			foodCart.setCustomer(customer);
			customer.setCart(foodCart);
			return customerRepo.save(customer);
		}

	}

	@Override
	public Customer updateCustomer(String key, Customer c) throws CustomerException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		if (c == null) {
			throw new CustomerException("Null value is not allowed");
		}

		Optional<Customer> optional = customerRepo.findById(c.getCustomerId());

		if (optional.isEmpty()) {
			throw new CustomerException("No customer exist with given customer id :" + c.getCustomerId());
		}
		// this statement will update customer and overrides the old customer data
		return customerRepo.save(c);
	}

	@Override
	public Customer removeCustomerById(String key, Integer customerId) throws CustomerException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<Customer> optional = customerRepo.findById(customerId);

		if (optional.isEmpty()) {
			throw new CustomerException("No customer exist with given customer id :" + customerId);
		}

		Customer deletedCustomer = optional.get();
		customerRepo.delete(deletedCustomer);
		return deletedCustomer;
	}

	@Override
	public Customer removeCustomer(String key, Customer c) throws CustomerException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		if (c == null) {
			throw new CustomerException("Null value is not allowed");
		}

		Optional<Customer> optional = customerRepo.findById(c.getCustomerId());

		if (optional.isEmpty()) {
			throw new CustomerException("No customer exist with given customer id :" + c.getCustomerId());
		}

		Customer deletedCustomer = optional.get();
		customerRepo.delete(deletedCustomer);
		return deletedCustomer;
	}

	@Override
	public Customer viewCustomer(String key, Integer cid) throws CustomerException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<Customer> optional = customerRepo.findById(cid);

		if (optional.isEmpty()) {
			throw new CustomerException("No customer exist with given customer id :" + cid);
		}

		return optional.get();
	}

	@Override
	public List<Customer> viewAllCustomers(String key) throws CustomerException, LoginException {

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		List<Customer> customers = customerRepo.findAll();

		if (customers.size() == 0) {
			throw new CustomerException("No customers available in list");
		}

		return customers;
	}

}

package com.pes_food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pes_food.exception.CustomerException;
import com.pes_food.exception.LoginException;
import com.pes_food.exception.OrderHistoryException;
import com.pes_food.model.CurrentUserSession;
import com.pes_food.model.Customer;
import com.pes_food.model.OrderHistory;
import com.pes_food.repository.CurrentUserSessionRepo;
import com.pes_food.repository.CustomerRepo;
import com.pes_food.repository.OrderHistoryRepo;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderHistoryRepo orderHistoryRepo;

	@Autowired
	private CurrentUserSessionRepo currSession;

	@Override
	public OrderHistory getOrderHistoryById(String key, Integer orderHisId)
			throws OrderHistoryException, LoginException {
		 

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<OrderHistory> opt = orderHistoryRepo.findById(orderHisId);
		if (opt.isEmpty())
			throw new OrderHistoryException("Order history not found!");

		return opt.get();
	}

	@Override
	public List<OrderHistory> getOrderHistoryByCustomerId(String key, Integer customerId)
			throws OrderHistoryException, LoginException, CustomerException {
		 

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess == null)
			throw new LoginException("Login required");

		Optional<Customer> opt = customerRepo.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("Customer not found!");

		List<OrderHistory> orderHistoryList = orderHistoryRepo.findByCustomerId(customerId);
		if (orderHistoryList.isEmpty())
			throw new OrderHistoryException("Order history not found!");
		return orderHistoryList;

	}

	@Override
	public List<OrderHistory> getAllOrderHistory(String key) throws OrderHistoryException, LoginException {
		 

		CurrentUserSession currSess = currSession.findByPrivateKey(key);
		if (currSess != null && currSess.getRole().equalsIgnoreCase("admin")) {

			List<OrderHistory> orderHistoryList = orderHistoryRepo.findAll();
			if (orderHistoryList.isEmpty())
				throw new OrderHistoryException("Order history list is empty!");
			return orderHistoryList;
		} else
			throw new LoginException("Admin login required");

	}

}

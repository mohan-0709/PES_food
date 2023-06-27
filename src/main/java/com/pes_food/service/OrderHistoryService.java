package com.pes_food.service;

import java.util.List;

import com.pes_food.exception.CustomerException;
import com.pes_food.exception.LoginException;
import com.pes_food.exception.OrderHistoryException;
import com.pes_food.model.OrderHistory;

public interface OrderHistoryService {

	public OrderHistory getOrderHistoryById(String key, Integer orderHisId)
			throws OrderHistoryException, LoginException;

	public List<OrderHistory> getOrderHistoryByCustomerId(String key, Integer customerId)
			throws OrderHistoryException, LoginException, CustomerException;

	public List<OrderHistory> getAllOrderHistory(String key) throws OrderHistoryException, LoginException;

}

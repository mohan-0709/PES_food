package com.pes_food.service;

import com.pes_food.exception.CustomerException;
import com.pes_food.exception.FoodCartException;
import com.pes_food.exception.LoginException;
import com.pes_food.exception.OrderDetailsException;
import com.pes_food.model.OrderDetails;

public interface OrderService {

	public OrderDetails addOrder(String key, Integer customerId)
			throws CustomerException, FoodCartException, LoginException;

	public OrderDetails updateOrder(String key, Integer orderId, Integer customerId)
			throws OrderDetailsException, CustomerException, FoodCartException, LoginException;

	public OrderDetails removeOrder(String key, Integer orderId) throws OrderDetailsException, LoginException;

	public OrderDetails viewOrder(String key, Integer orderId) throws OrderDetailsException, LoginException;

}

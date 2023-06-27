package com.pes_food.service;

import com.pes_food.exception.CustomerException;
import com.pes_food.exception.FoodCartException;
import com.pes_food.exception.ItemException;
import com.pes_food.exception.LoginException;
import com.pes_food.model.CustomerDTO;
import com.pes_food.model.FoodCart;
import com.pes_food.model.ItemDTO;

public interface FoodCartService {
	
	public FoodCart addItemToCart(String key, Integer customerId, Integer itemId) throws ItemException, CustomerException, LoginException;
	
	public FoodCart increaseItemQuantity(String key, Integer cartId, Integer quantity, Integer itemId) throws FoodCartException, ItemException, LoginException;

	public FoodCart decreaseItemQuantity(String key, Integer cartId, Integer quantity, Integer itemId) throws FoodCartException, ItemException, LoginException;
	
	public FoodCart removeItem(String key, Integer cartId, Integer itemId) throws FoodCartException, ItemException, LoginException;
	
	public FoodCart removeCart(String key, Integer cartId) throws FoodCartException, LoginException;
}

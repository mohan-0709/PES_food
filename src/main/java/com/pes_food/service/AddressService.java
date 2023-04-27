package com.pes_food.service;

import java.util.List;

import com.pes_food.exception.AddressException;
import com.pes_food.model.Restaurant;

public interface AddressService {
	
	public List<Restaurant> getAllRestaurantsByAddressId(Integer addressId) throws AddressException;

}

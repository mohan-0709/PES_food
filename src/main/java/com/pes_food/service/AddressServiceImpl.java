package com.pes_food.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pes_food.exception.AddressException;
import com.pes_food.exception.RestaurantException;
import com.pes_food.model.Address;
import com.pes_food.model.Restaurant;
import com.pes_food.repository.AddressRepo;

@Service
public class AddressServiceImpl implements AddressService{

	@Override
	public List<Restaurant> getAllRestaurantsByAddressId(Integer addressId) throws AddressException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

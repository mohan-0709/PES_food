package com.pes_food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pes_food.exception.AddressException;
import com.pes_food.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

	public Address findByCity(String city) throws AddressException;
	
}

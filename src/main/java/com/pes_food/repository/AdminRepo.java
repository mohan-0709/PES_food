package com.pes_food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pes_food.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);

}

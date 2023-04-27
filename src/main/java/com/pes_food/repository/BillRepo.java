package com.pes_food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pes_food.model.Bill;

@Repository
public interface BillRepo extends JpaRepository<Bill, Integer>{

}



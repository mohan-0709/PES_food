package com.pes_food.service;

import com.pes_food.exception.BillException;
import com.pes_food.exception.CustomerException;
import com.pes_food.exception.ItemException;
import com.pes_food.exception.LoginException;
import com.pes_food.exception.OrderDetailsException;
import com.pes_food.model.Bill;

public interface BillService {

	public Bill generateBill(String key, Integer customerId, Integer orderDetailId)
			throws BillException, CustomerException, OrderDetailsException, LoginException;

	public Bill updateBill(String key, Bill bill) throws BillException, LoginException;

	public Bill removeBill(String key, Integer billId) throws BillException, LoginException;

	public Bill viewBill(String key, Integer billId) throws BillException, LoginException;

}

package com.pes_food.service;

import com.pes_food.exception.AdminException;
import com.pes_food.model.Admin;

public interface AdminService {

	public String createNewAdmin() throws AdminException;

}

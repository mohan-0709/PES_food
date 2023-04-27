package com.pes_food.service;

import com.pes_food.exception.LoginException;
import com.pes_food.model.*;


public interface LoginService {

	public String loginAccount(LoginDTO loginDTO) throws LoginException;

	public String logoutAccount(String role, String key) throws LoginException;

}

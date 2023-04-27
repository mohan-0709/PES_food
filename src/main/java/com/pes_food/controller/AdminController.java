package com.pes_food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pes_food.exception.AdminException;
import com.pes_food.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/new")
	public ResponseEntity<String> createAdmin() throws AdminException{
		String result=adminService.createNewAdmin();
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

}

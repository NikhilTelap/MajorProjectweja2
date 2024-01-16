package com.jspiders.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.studentmanagementsystem.pojo.AdminPOJO;
import com.jspiders.studentmanagementsystem.response.AdminResponse;
import com.jspiders.studentmanagementsystem.service.AdminService;


@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping("/createAccount")
	public ResponseEntity<?> createAccount(@RequestBody AdminPOJO pojo){
		
		AdminPOJO admin = service.createAccount(pojo);
		
		if(admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account created successfully..", pojo),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<AdminResponse>(new AdminResponse("account not created", admin),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AdminPOJO pojo){
		
		AdminPOJO admin = service.login(pojo);
		
		if(admin != null) {
			
			return new ResponseEntity<AdminResponse>(new AdminResponse("login successful", pojo),HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<AdminResponse>(new AdminResponse("login unsuccessful", pojo),HttpStatus.NOT_ACCEPTABLE);
	}


}

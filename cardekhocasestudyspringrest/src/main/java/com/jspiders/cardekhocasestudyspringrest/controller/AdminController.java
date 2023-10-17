package com.jspiders.cardekhocasestudyspringrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekhocasestudyspringrest.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudyspringrest.response.AdminResponse;
import com.jspiders.cardekhocasestudyspringrest.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping(path="/createAccount",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAccount(@RequestBody AdminPOJO pojo){
		
		AdminPOJO admin = service.createAccount(pojo);
		
		if(admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account created successfully", admin),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account already exists.. ", null),HttpStatus.NOT_ACCEPTABLE);

	}
	
	@PostMapping(path="/login",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> login(@RequestBody AdminPOJO pojo){
		
		AdminPOJO admin = service.login(pojo);
		
		if(admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Login Successful..", admin),HttpStatus.OK);
		}
		return new ResponseEntity<AdminResponse>(new AdminResponse("Login Unsuccessful..", null),HttpStatus.OK);

		
	}
	
}

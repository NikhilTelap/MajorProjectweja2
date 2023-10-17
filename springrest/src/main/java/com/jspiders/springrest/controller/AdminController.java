package com.jspiders.springrest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.springrest.pojo.AdminPOJO;
import com.jspiders.springrest.response.AdminResponse;
import com.jspiders.springrest.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping(path="/createAccount",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAccount(@RequestBody AdminPOJO pojo )
	{
		AdminPOJO admin = service.createAdmin(pojo);
		
		//success
		if(admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account created", admin),HttpStatus.ACCEPTED);
		}
		//failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account not created", null),HttpStatus.NOT_ACCEPTABLE);
	
	
	}
	
	@PostMapping(path="/login",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> login(@RequestBody AdminPOJO pojo){
		
		AdminPOJO admin = service.login(pojo);
		
		//success
		if(admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("login successful", admin),HttpStatus.OK);
		}
		//failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("login unsuccessful", null),HttpStatus.OK);
	}
	
}

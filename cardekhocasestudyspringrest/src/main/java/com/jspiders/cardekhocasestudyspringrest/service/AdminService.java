package com.jspiders.cardekhocasestudyspringrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhocasestudyspringrest.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudyspringrest.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public AdminPOJO createAccount(AdminPOJO pojo) {

		AdminPOJO admin = repository.createAdmin(pojo);
		
		return admin;
	}

	public AdminPOJO login(AdminPOJO pojo) {

		AdminPOJO admin = repository.login(pojo);
		
		return admin;
	}

}

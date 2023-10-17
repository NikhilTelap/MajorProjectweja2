package com.jspiders.gymmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.gymmanagementsystem.pojo.CustomerPOJO;
import com.jspiders.gymmanagementsystem.repository.CustomerRepository;

@Service
public class CustomerService {

@Autowired
private CustomerRepository repository;
	
	public CustomerPOJO Customer(String name, String email, long contact, int age, String address, String time) {
	
		CustomerPOJO customer = repository.Customer(name,email,contact,age,address,time);
		
		return customer;
	}

}

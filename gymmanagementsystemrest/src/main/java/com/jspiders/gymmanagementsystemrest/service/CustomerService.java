package com.jspiders.gymmanagementsystemrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.gymmanagementsystemrest.pojo.CustomerPOJO;
import com.jspiders.gymmanagementsystemrest.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	public CustomerPOJO addCustomer(CustomerPOJO pojo) {
		
		CustomerPOJO customer = repository.addCustomer(pojo);
		return customer;
	}

}

package com.jspiders.gymmanagementsystemrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.gymmanagementsystemrest.pojo.CustomerPOJO;
import com.jspiders.gymmanagementsystemrest.response.CustomerResponse;
import com.jspiders.gymmanagementsystemrest.service.CustomerService;

@RestController
public class CustomerController {

@Autowired
private CustomerService service;

@PostMapping(path="addCustomer",
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerPOJO pojo)
{
	CustomerPOJO customer = service.addCustomer(pojo);
	
	if(customer != null) {
		return new ResponseEntity<CustomerResponse>(new CustomerResponse("customer added successfully..", customer),HttpStatus.ACCEPTED);
	}
	return new ResponseEntity<CustomerResponse>(new CustomerResponse("customer not added..", customer),HttpStatus.NOT_ACCEPTABLE);

}
}

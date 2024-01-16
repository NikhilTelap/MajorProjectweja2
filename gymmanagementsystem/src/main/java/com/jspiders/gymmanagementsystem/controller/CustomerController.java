package com.jspiders.gymmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.gymmanagementsystem.pojo.CustomerPOJO;
import com.jspiders.gymmanagementsystem.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;


	@GetMapping("/homePage")
	public String homePage() {
		return "Home";
	}
	

	@GetMapping("/customerPage")
	public String customerPage() {
		
		return "Customer";
	}
	
	@PostMapping("/customer")
	public String customer(@RequestParam String name,
							@RequestParam String email,
							@RequestParam long contact , 
							@RequestParam int age,
							@RequestParam String address,
							@RequestParam String time,ModelMap map) {

		CustomerPOJO customer = service.Customer(name,email,contact,age,address,time);
		
		if(customer != null) {
			map.addAttribute("msg", "Customer added successfully..");
			return "Home";
		}
		map.addAttribute("msg", "Trainer not added");
		return "Home";
	}
}

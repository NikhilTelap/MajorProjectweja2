package com.jspiders.gymmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.gymmanagementsystem.pojo.TrainerPOJO;
import com.jspiders.gymmanagementsystem.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
private	TrainerRepository repository;

	
	public TrainerPOJO Trainer(String name, String email, long contact, int age, String address, String time) {

	TrainerPOJO trainer = repository.Trainer(name,email,contact,age,address,time);	
		return trainer;
	}

	
}

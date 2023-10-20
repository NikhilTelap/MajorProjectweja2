package com.jspiders.gymmanagementsystemrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.gymmanagementsystemrest.pojo.TrainerPOJO;
import com.jspiders.gymmanagementsystemrest.repository.TrainerRepository;
import com.jspiders.gymmanagementsystemrest.response.TrainerResponse;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository repository;

	public TrainerPOJO addTrainer(TrainerPOJO pojo) {

		TrainerPOJO trainer = repository.addTrainer(pojo);
		return trainer;
	}
	
	
}

package com.jspiders.gymmanagementsystemrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.gymmanagementsystemrest.pojo.TrainerPOJO;
import com.jspiders.gymmanagementsystemrest.response.TrainerResponse;
import com.jspiders.gymmanagementsystemrest.service.TrainerService;

@RestController
public class TrainerController {

	@Autowired
	private TrainerService service;
	
	@PostMapping(path="addTrainer",
				consumes=MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrainerResponse> addTrainer(@RequestBody TrainerPOJO pojo){
		
		TrainerPOJO trainer = service.addTrainer(pojo);
		
		if(trainer != null) {
			return new ResponseEntity<TrainerResponse>(new TrainerResponse("trainer added successfully",trainer),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<TrainerResponse>(new TrainerResponse("Trainer not added..",null),HttpStatus.NOT_ACCEPTABLE);

		
	}
	
}

package com.jspiders.gymmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.gymmanagementsystem.pojo.TrainerPOJO;
import com.jspiders.gymmanagementsystem.service.TrainerService;

@Controller
public class TrainerController {
	
	@Autowired
	private TrainerService service;
	
	@GetMapping("/trainerPage")
	public String trainerPage() {
		
		return "Trainer";
	}
	
	
	@PostMapping("/trainer")
	public String trainer(@RequestParam String name,
							@RequestParam String email,
							@RequestParam long contact , 
							@RequestParam int age,
							@RequestParam String address,
							@RequestParam String time,ModelMap map) {

		TrainerPOJO trainer = service.Trainer(name,email,contact,age,address,time);
		
		if(trainer != null) {
			map.addAttribute("msg", "Trainer added successfully..");
			return "Home";
		}
		map.addAttribute("msg", "Trainer not added");
		return "Home";
	}
}

package com.jspiders.cardekhocasestudyspringmvc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.cardekhocasestudyspringmvc2.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudyspringmvc2.pojo.CarPOJO;
import com.jspiders.cardekhocasestudyspringmvc2.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService service;
	
	
	
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
		if(admin != null) {
		return "Home";
	}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
	}
	
	
	
	
	@GetMapping("/add")
	public String addCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
		if(admin != null) {
		List<CarPOJO> cars = service.findAllCars();
		map.addAttribute("cars", cars);
		return "Add";
	}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
	}
	
	
	
	
	@PostMapping("/add")
	public String addCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam String name,
						@RequestParam String brand,
						@RequestParam String fuelType,
						@RequestParam String color,
						@RequestParam long price,ModelMap map) {
		
		
		if(admin != null) {
		CarPOJO car = service.addCar(name,brand,fuelType,color,price);
		
		if(car != null) {
			map.addAttribute("msg", "CAR ADDED SUCCESSFULLY..");
			map.addAttribute("car", car);
			
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Add";
		}
		map.addAttribute("msg", "CAR NOT ADDED... ");
		List<CarPOJO> cars = service.findAllCars();
		map.addAttribute("cars", cars);
		return "Add";
	}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
		
	}
	
	
	
	
	@GetMapping("/update")
	public String updateCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
		if(admin != null) {
		List<CarPOJO> cars = service.findAllCars();
		map.addAttribute("cars", cars);
		return "Update";
	}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
	}
	
	
	
	
	@PostMapping("/update")
	public String updatePage(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,ModelMap map) {
		
		if(admin != null) {
			
		
		CarPOJO car = service.searchCar(id);
		
		if(car != null) {
			map.addAttribute("msg", "CAR FOUND SUCCESSFULLY...");
			map.addAttribute("car", car);
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "CAR NOT FOUND..! ");
		List<CarPOJO> cars = service.findAllCars();
		map.addAttribute("cars", cars);
		return "Update";
	}
	map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
	return "Login";
	
}
	
	
	
	
	@PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
			@RequestParam String name,
			@RequestParam String brand,
			@RequestParam String fuelType,
			@RequestParam String color,
			@RequestParam long price,ModelMap map) {
		
		if(admin != null) {
	CarPOJO car = service.updateCar(id,name,brand,fuelType,color,price);
	
	if(car != null) {
		map.addAttribute("msg", "CAR UPDATED SUCCESSFULLY..");
		List<CarPOJO> cars = service.findAllCars();
		map.addAttribute("cars", cars);
		return "Update";
	}
	map.addAttribute("msg", "CAR NOT UPDATED..!");

	List<CarPOJO> cars = service.findAllCars();
	map.addAttribute("cars", cars);
		return "Update";
		
	}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
		
	}
	
	
	
	
	
	@GetMapping("/remove")
	public String removeCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
		
		if(admin != null) {
			
		
		List<CarPOJO> cars = service.findAllCars();
		map.addAttribute("cars", cars);
		return "Remove";
	}
	map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
	return "Login";
	
}
	
	
	
	
	@PostMapping("/remove")
	public String removeCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,ModelMap map) {
		
		
		if(admin != null) {
		CarPOJO car = service.removeCar(id);
		
		if(car != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg","CAR REMOVED SUCCESSFULLY..");
			return "Remove";
		}
		List<CarPOJO> cars = service.findAllCars();
		map.addAttribute("cars", cars);
		map.addAttribute("msg","CAR NOT REMOVED..!");

		return "Remove";
		}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
	}
	

	
	
	@GetMapping("/search")
	public String searchCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
		if(admin != null) {
		
		return "Search";
	}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
	}
	
	
	
	
	@PostMapping("/search")
	public String searchCar(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,ModelMap map)
	{
		if(admin != null) {
		CarPOJO car = service.searchCar(id);
		
		if(car != null) {
			map.addAttribute("msg","CAR FOUND SUCCESSFULLY...");
			map.addAttribute("car",car);
			return "Search";
		}
		
		map.addAttribute("msg","CAR NOT FOUND..!");
		return "Search";

	}
		map.addAttribute("msg","SESSION INACTIVE . PLEASE LOGIN AGAIN...");
		return "Login";
	}
	
	
	
	
	
}

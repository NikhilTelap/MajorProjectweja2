package com.jspiders.cardekhocasestudyspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import com.jspiders.cardekhocasestudyspringrest.pojo.CarPOJO;
import com.jspiders.cardekhocasestudyspringrest.response.CarResponse;
import com.jspiders.cardekhocasestudyspringrest.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService service;
	
		@PostMapping(path="/add",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<CarResponse> addCar(@RequestBody CarPOJO pojo){
			
			CarPOJO car = service.addCar(pojo);

			if(car != null) {
				return new ResponseEntity<CarResponse>(new CarResponse("car added successfully", null, car),HttpStatus.FOUND);
			}
		//Failure
			return new ResponseEntity<CarResponse>(new CarResponse("car not added ", null, null),HttpStatus.NOT_FOUND);

			
			
		}
		
		@GetMapping(path="/search/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE)
		
		public ResponseEntity<CarResponse> searchCar(@PathVariable int id){
			
			CarPOJO car = service.searchCar(id);
			
			if(car != null) {
				return new ResponseEntity<CarResponse>(new CarResponse("Car Found successfully", null, car),HttpStatus.FOUND);
			}
			return new ResponseEntity<CarResponse>(new CarResponse("Car not Found", null, car),HttpStatus.FOUND);

		}
		
		@GetMapping(path="/searchAll",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<CarResponse> searchAllCars(){
			
			List<CarPOJO> cars = service.searchAllCars(); 
			
			if(cars != null) {
				return new ResponseEntity<CarResponse>(new CarResponse("Cars found successfully", cars, null),HttpStatus.FOUND);
			}
			return new ResponseEntity<CarResponse>(new CarResponse("Cars not found ", null, null),HttpStatus.NOT_FOUND);

		}
		
		
		@DeleteMapping(path="/remove/{id}",
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<CarResponse> deleteCar(@PathVariable int id){
			
			CarPOJO car = service.RemoveCar(id);
			if(car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car removed successfully..", null, car),HttpStatus.OK);
			}
			return new ResponseEntity<CarResponse>(new CarResponse("Car not removed ..", null, null),HttpStatus.BAD_REQUEST);

		}
		
		@PostMapping(path="/update",
				consumes =MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<CarResponse> updateCar(@RequestBody CarPOJO pojo){
			
			CarPOJO car = service.updateCar(pojo);
			
			if(car != null) {
				return new ResponseEntity<CarResponse>(new CarResponse("car updated successfully", null, car),HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<CarResponse>(new CarResponse("car not updated ", null, car),HttpStatus.NOT_ACCEPTABLE);

		}

		
}

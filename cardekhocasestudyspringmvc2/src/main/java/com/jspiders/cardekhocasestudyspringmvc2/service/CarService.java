package com.jspiders.cardekhocasestudyspringmvc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhocasestudyspringmvc2.pojo.CarPOJO;
import com.jspiders.cardekhocasestudyspringmvc2.repository.CarRepository;

@Service
public class CarService {
	

	@Autowired
	private CarRepository repository ;
	
	public CarPOJO addCar(String name, String brand, String fuelType, String color, long price) {
		
		
		
		
		CarPOJO car = repository.addCar(name,brand,fuelType,color,price);
		
		for(int i=0;i<=9;i++) {	
			
			if(car.getName().charAt(0)==i) {
					return null;
				}	

			}

				return car;
	}

	public List<CarPOJO> findAllCars() {

		List<CarPOJO> cars = repository.findAllCars();
		
		return cars;
	}

	public CarPOJO searchCar(int id) {

	
		
		CarPOJO car = repository.searchCar(id);
		
		return car;
	}

	public CarPOJO removeCar(int id) {

		if(id == 1) {
			return null;
		}
		CarPOJO car = repository.removeCar(id);
		
		return car;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuelType, String color, long price) {

		
	CarPOJO car = repository.updateCar(id,name,brand,fuelType,color,price);
		
		return car;
	}

	
}

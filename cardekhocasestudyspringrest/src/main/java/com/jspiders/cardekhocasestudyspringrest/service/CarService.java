package com.jspiders.cardekhocasestudyspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekhocasestudyspringrest.pojo.CarPOJO;
import com.jspiders.cardekhocasestudyspringrest.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(CarPOJO pojo) {

		CarPOJO car =repository.addCar(pojo);
		
		return car;
	}

	public CarPOJO searchCar(int id) {

		CarPOJO car = repository.searchCar(id);
		
		return car;
	}

	public CarPOJO RemoveCar(int id) {

		CarPOJO car = repository.removeCar(id);
;		
		return car;
	}

	public CarPOJO updateCar(CarPOJO pojo) {
		
		CarPOJO car = repository.updateCar(pojo);
		
		return car;
	}

	public List<CarPOJO> searchAllCars() {

		List<CarPOJO> cars = repository.searchAllCars();
		
		return cars;
	}

}

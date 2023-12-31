package com.jspiders.cardekhocasestudyspringrest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.cardekhocasestudyspringrest.pojo.CarPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

	private String msg;
	private List<CarPOJO> cars;
	private CarPOJO car;
	
	
}

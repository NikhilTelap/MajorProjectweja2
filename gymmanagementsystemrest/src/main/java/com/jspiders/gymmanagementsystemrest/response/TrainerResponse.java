package com.jspiders.gymmanagementsystemrest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.gymmanagementsystemrest.pojo.TrainerPOJO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TrainerResponse {

	private String msg;
	private TrainerPOJO trainer;
}

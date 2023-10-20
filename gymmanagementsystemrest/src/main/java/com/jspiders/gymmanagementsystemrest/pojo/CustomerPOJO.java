package com.jspiders.gymmanagementsystemrest.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class CustomerPOJO {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String name;
	private String email;
	private long contact;
	private int age;
	private String address;
	private String time;

}

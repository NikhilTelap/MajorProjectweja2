package com.jspiders.springmvc1.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AdminPOJO {

	@Id
	private int id;
	private String username;
	private String password;
	
}

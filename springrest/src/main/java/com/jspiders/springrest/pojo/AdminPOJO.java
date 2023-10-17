package com.jspiders.springrest.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AdminPOJO {

	@Id
	private String username;
	private String password;
	
}

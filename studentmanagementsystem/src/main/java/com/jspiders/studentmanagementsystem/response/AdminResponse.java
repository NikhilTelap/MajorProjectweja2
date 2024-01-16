package com.jspiders.studentmanagementsystem.response;


import com.jspiders.studentmanagementsystem.pojo.AdminPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {

	private String msg;
	private AdminPOJO pojo;
}

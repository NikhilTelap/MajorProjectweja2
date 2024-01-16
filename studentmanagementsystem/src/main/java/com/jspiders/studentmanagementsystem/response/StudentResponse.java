package com.jspiders.studentmanagementsystem.response;

import java.util.List;

import com.jspiders.studentmanagementsystem.pojo.StudentPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

	private String msg;
	private StudentPOJO data;
	private List<StudentPOJO> list;
}

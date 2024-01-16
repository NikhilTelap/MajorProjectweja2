package com.jspiders.studentmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.studentmanagementsystem.exception.InvalidContactException;
import com.jspiders.studentmanagementsystem.exception.InvalidEmailException;
import com.jspiders.studentmanagementsystem.pojo.StudentPOJO;
import com.jspiders.studentmanagementsystem.response.StudentResponse;
import com.jspiders.studentmanagementsystem.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@RequestBody StudentPOJO pojo){
		
		try {
		StudentPOJO student =service.addStudent(pojo);
		
		if(student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student added successfully", student, null),HttpStatus.ACCEPTED);
		}
		
			return new ResponseEntity<StudentResponse>(new StudentResponse("Data not added.", student, null),HttpStatus.NOT_ACCEPTABLE);
	}
		catch(InvalidEmailException | InvalidContactException e) {
			return new ResponseEntity<InvalidEmailException>(new InvalidEmailException(true, "Invalid email.."),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	
	@GetMapping("/searchById/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		
		StudentPOJO student = service.findById(id);
		
		if(student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("data found successfully.", student, null),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Data not found.", student, null),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/searchByName/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		
		List<StudentPOJO> students = service.findByName(name);
		
		if(students.isEmpty() == false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student found successfully", null, students),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student not found.", null, students),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/searchByEmail/{email}")
	public ResponseEntity<?> searchByEmail(@PathVariable String email){
		
		List<StudentPOJO> students = service.findByEmail(email);
		
		if(students.isEmpty()==false) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Students found successfully.", null, students),HttpStatus.FOUND);
			}

	
	return new ResponseEntity<StudentResponse> (new StudentResponse("Students not found", null, students),HttpStatus.FOUND); 
	}
	
	@GetMapping("/searchAll")
	public ResponseEntity<?> searchAll(){
		
		List<StudentPOJO> students = service.searchAll();
		if(students.isEmpty()) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("studets found successfully..", null, students),HttpStatus.FOUND);
			
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("students not found", null, students),HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/remove/{id}")
	public ResponseEntity<?> removeStudent(@PathVariable  int id){
		
		StudentPOJO student = service.removeStudent(id);
		
		if(student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("Student deleted successfully..", student, null),HttpStatus.ACCEPTED);
			
		}
		
		return new ResponseEntity<StudentResponse>(new StudentResponse("Student not deleted ", student, null),HttpStatus.NOT_ACCEPTABLE);

	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateStudent(@RequestBody StudentPOJO pojo){
		
		try {
		StudentPOJO student = service.updateStudent(pojo);
		
		if(student != null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse("student updated successfully.", student, null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse("student not updated", student, null),HttpStatus.BAD_REQUEST);
	}
		catch(InvalidEmailException | InvalidContactException e) {
			return new ResponseEntity<InvalidEmailException>(new InvalidEmailException(true, "Invalid email.."),HttpStatus.NOT_ACCEPTABLE);
		}
		}
}

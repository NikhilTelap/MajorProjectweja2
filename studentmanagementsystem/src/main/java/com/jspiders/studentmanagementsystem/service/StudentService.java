package com.jspiders.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jspiders.studentmanagementsystem.exception.InvalidContactException;
import com.jspiders.studentmanagementsystem.exception.InvalidEmailException;
import com.jspiders.studentmanagementsystem.pojo.StudentPOJO;
import com.jspiders.studentmanagementsystem.repository.StudentRespository;

@Service
public class StudentService {

	@Autowired
	private StudentRespository repository;
	
	public StudentPOJO addStudent(StudentPOJO pojo) throws InvalidEmailException, InvalidContactException {

		if(pojo.getEmail().contains("@") ) {
			
			if(pojo.getContact()>0) {
				long contact = pojo.getContact();
				
				int counter=0;
				while(contact>0) {
					counter++;
					contact=contact/10;
				}
			
			if(counter==10) {
				StudentPOJO student = repository.save(pojo);
				return student;
	
			}
			}
			else {
					throw new InvalidContactException();	
			}
			
	}
		throw new InvalidEmailException();
	}
	
	
	public StudentPOJO findById(int id) {

		StudentPOJO student = repository.findById(id).orElse(null);
		return student;
	}

	public List<StudentPOJO> findByName(String name) {

		List<StudentPOJO> students = repository.findByName(name);
		return students;
	}

	public List<StudentPOJO> findByEmail(String email) {

		List<StudentPOJO> students = repository.findByEmail(email);
		return students;
	}


	public List<StudentPOJO> searchAll() {

		List<StudentPOJO> students = repository.findAll();
		
		return students;
	}


	public StudentPOJO removeStudent(int id) {

		StudentPOJO student = repository.findById(id).orElse(null);
		if(student != null) {
			repository.delete(student);
			return student;
			
		}
		return null;
	}


	public StudentPOJO updateStudent(StudentPOJO pojo) throws InvalidContactException, InvalidEmailException {
		
		
				if(pojo.getEmail().contains("@") ) {
			
			if(pojo.getContact()>0) {
				long contact = pojo.getContact();
				
				int counter=0;
				while(contact>0) {
					counter++;
					contact=contact/10;
				}
			
			if(counter==10) {
				StudentPOJO student = repository.findById(pojo.getId()).orElse(null);
				
				if(student != null) {
					student.setName(pojo.getName());
					student.setEmail(pojo.getEmail());
					student.setContact(pojo.getContact());
					student.setAddress(pojo.getAddress());
					
					repository.save(student);
					
					return student;
				}
			}
			}
			else {
					throw new InvalidContactException();	
			}
			
	}
		throw new InvalidEmailException();

	}
	
	
}

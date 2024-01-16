package com.jspiders.studentmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.studentmanagementsystem.pojo.StudentPOJO;

@Repository
public interface StudentRespository extends JpaRepository<StudentPOJO, Integer>{

	
	List<StudentPOJO> findByName(String name);

	List<StudentPOJO> findByEmail(String email);
	
}

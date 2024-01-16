package com.jspiders.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.studentmanagementsystem.pojo.AdminPOJO;

@Repository
public interface AdminRepository extends JpaRepository<AdminPOJO, String>{

}

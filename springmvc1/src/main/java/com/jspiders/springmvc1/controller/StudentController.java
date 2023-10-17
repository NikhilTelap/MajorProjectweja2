package com.jspiders.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc1.pojo.AdminPOJO;
import com.jspiders.springmvc1.pojo.StudentPOJO;
import com.jspiders.springmvc1.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/home")
	public String homePage() {
		
		return "Home";
				
	}
	
	
	
	
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name="login",required = false)AdminPOJO admin,  ModelMap map) {
		
		if(admin != null) {
		List<StudentPOJO> students = service.findAllStudents();
		
		//success
		if(students != null) {
			map.addAttribute("students", students);
			return "Add";
		}
		return "Add";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
		
		}
	
	@PostMapping("/add")
	public String addStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam String name,
								@RequestParam String email,
								@RequestParam String contact,
								@RequestParam String address,ModelMap map){
		if(admin != null) {
		StudentPOJO pojo  =service.addStudent(name,email,contact,address); 
		
		List<StudentPOJO> students = service.findAllStudents();
		
		//success
		if(pojo != null) {
			map.addAttribute("msg", "Student Added Successfully...");
			map.addAttribute("students", students);
		return "/Add";
	}
		map.addAttribute("students", students);
		map.addAttribute("msg", "Student Not Added ...");
		return "/Add";	
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
	}

	
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		
		if(admin != null) {
		List<StudentPOJO> students = service.findAllStudents();
		if(students != null) {
			map.addAttribute("students", students);
			return "Remove";
		}
		return "Remove";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
	}
	
	@PostMapping("/remove")
	public String removeStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,ModelMap map) {
		
		if(admin != null) {
		StudentPOJO pojo =service.removeStudent(id);
	List<StudentPOJO> students = service.findAllStudents();
		
		//success
		if(pojo != null) {
			map.addAttribute("msg", "Student Remove successfully..");
			map.addAttribute("students", students);
			return "Remove";
		}
		map.addAttribute("msg", "Student does not exists..");
		map.addAttribute("students", students);
		return "Remove";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
	}
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
		if(admin != null) {
		List<StudentPOJO> students = service.findAllStudents();
		
		if(students.isEmpty()==false) {
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("students", students);
		return "Update";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
		
	}
	
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
								ModelMap map) {
		if(admin != null) {
		StudentPOJO pojo =service.searchStudent(id);
		
		if(pojo != null) {
			map.addAttribute("student", pojo);
			return "Update";
		}
		map.addAttribute("msg", "Entered Student not found");
		return "Update";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
	
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,@RequestParam int id,
								@RequestParam String name,
								@RequestParam String email,
								@RequestParam String contact,
								@RequestParam String address,ModelMap map) {
		if(admin != null) {
		StudentPOJO pojo = service.updateStudent(id,name,email,contact,address);
		
		//success
		if(pojo != null) {
			
			List<StudentPOJO> students = service.findAllStudents();
			map.addAttribute("students", students);
			map.addAttribute("msg","Student updated successfully");
			
			return "Update";
					}
		List<StudentPOJO> students = service.findAllStudents();
		map.addAttribute("students", students);
		map.addAttribute("msg","Student not updated");
		return "Update";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";

	}
	
	
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name="login",required = false)AdminPOJO admin,ModelMap map) {
	
		if(admin != null) {
		return "Search";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
	}
	
	@PostMapping("/search")
	public String searchStudent(@SessionAttribute(name="login",required = false)AdminPOJO admin,
			@RequestParam int id , ModelMap map) {
	
		if(admin != null) {
		StudentPOJO pojo = service.searchStudent(id);
		
		//success
		if(pojo != null) {
			map.addAttribute("msg","Student Found");
			map.addAttribute("student", pojo);
			return "Search";
		}
		map.addAttribute("msg", "Student not found");
		return"Search";
		}
		map.addAttribute("msg", "Session Inactive please login..");
		return "Login";
	}
	
	
	
	
}

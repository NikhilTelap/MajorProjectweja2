package com.jspiders.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.springmvc1.pojo.AdminPOJO;
import com.jspiders.springmvc1.service.AdminService;
import com.mysql.cj.Session;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/createAccount")
	public String createAccount(ModelMap map) {
		
		AdminPOJO pojo = service.getAdmin();
		
		if(pojo != null) {
			map.addAttribute("msg", "Account already exists");
			return "Login";
		}
		
		return "CreateAccount";
	}
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,
					@RequestParam String password,ModelMap map) {
		
		AdminPOJO pojo = service.createAccount(username,password);
		
		if(pojo != null) {
			map.addAttribute("msg", "Account created successfully..");
			return "Login";
		}
		map.addAttribute("msg","Account not created try again..");
		
		return "Login";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "Login";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam String username,
						@RequestParam String password,ModelMap map,HttpSession session) {
		AdminPOJO pojo = service.login(username,password);
		
		if(pojo != null) {
			session.setAttribute("login", pojo);
			return "Home";
		}
		map.addAttribute("msg", "Username or password is incorrect");
		return "Login";
	}
	
	
	@GetMapping("/logout")
	public String logoutPage(HttpSession session ) {
		session.invalidate();
		return "Login";
	}

}

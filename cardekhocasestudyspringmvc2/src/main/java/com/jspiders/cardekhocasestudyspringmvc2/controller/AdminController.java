package com.jspiders.cardekhocasestudyspringmvc2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.cardekhocasestudyspringmvc2.pojo.AdminPOJO;
import com.jspiders.cardekhocasestudyspringmvc2.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {


		@Autowired
		private AdminService service;
		
		@GetMapping("/createAccount")
		public String createAccount(ModelMap map) {
			
			AdminPOJO pojo = service.getAdmin();
			
			if(pojo != null) {
				map.addAttribute("msg", "ACCOUNT ALREADY EXISTS...");
				return "Login";
			}
			return "CreateAccount";
		}
		
		
		@PostMapping("/createAccount")
		public String createAccount(@RequestParam String username,
									@RequestParam String password,
									ModelMap map) {
			
			AdminPOJO admin = service.createAccount(username,password);
			
			if(admin != null) {
				map.addAttribute("msg", "ACCOUNT CREATED SUCCESSFULLY...");
				return "Login";
			}
			map.addAttribute("msg", "ACCOUNT NOT CREATED ..");

			return "Login";
		}
		
		
		@GetMapping("/login")
		public String loginPage() {
			return "Login";
		}
		
		
		@PostMapping("/login")
		public String login(@RequestParam String username,
							@RequestParam String password,ModelMap map,HttpSession session) {
			AdminPOJO admin = service.login(username,password);
			
			if(admin != null) {
				session.setAttribute("login", admin);
				map.addAttribute("msg", "LOGIN SUCCESSFUL..");
				return "Home";
				
			}
			map.addAttribute("msg", "INCORRECT USERNAME OR PASSWORD..TRY AGAIN...");

			return "Login";
		}
		
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "Login";
		}
}





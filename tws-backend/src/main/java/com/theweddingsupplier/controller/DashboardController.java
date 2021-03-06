package com.theweddingsupplier.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="*", allowedHeaders ="*")
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String testLogin() {
		System.out.println("Login successfully");
		return "successCall";
	}
}

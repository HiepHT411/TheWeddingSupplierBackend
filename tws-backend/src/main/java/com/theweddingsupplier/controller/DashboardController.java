package com.theweddingsupplier.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins ="*", allowedHeaders ="*")
@RestController
@RequestMapping(path = "/api/tws")
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String testLogin() {
		System.out.println("Login successfully");
		return "successCall";
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}
}

package com.theweddingsupplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theweddingsupplier.model.User;
import com.theweddingsupplier.payload.MessageResponse;
import com.theweddingsupplier.repository.UserRepository;
import com.theweddingsupplier.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Slf4j
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	// signup in JwtAuthenticationController
//	@PostMapping(path = "/signup")	
//	public ResponseEntity<?> saveUser(@RequestBody User user) {
//		if(userRepository.existsByName(user.getName())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken"));
//		}
//		if(userRepository.existsByEmail(user.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use"));
//		}
//		log.info("Add user to database "+ user.getName());
//		userService.addUserToDB(user);
//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	}
	
	@GetMapping(path = "/findByUsername")
	public User Test(){
		return userService.findByUsername("Hiep");
	}
	
	@GetMapping("/all")
	public String allAccess() {
		return "publicContent";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return "confirmedUserRole";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "confirmedAdminRole";
	}
}

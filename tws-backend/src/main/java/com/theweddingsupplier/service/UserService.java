package com.theweddingsupplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.theweddingsupplier.model.User;
import com.theweddingsupplier.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User addUserToDB(User user) {
		return userRepo.save(user);
	}
	
	public User findByUsername(String name) throws UsernameNotFoundException{
		User user =  userRepo.findByUsername(name)
				.orElseThrow(() ->new UsernameNotFoundException("User not found with username: "+ name));
		return user;
	}
}

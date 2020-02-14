package com.app.fogether.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.fogether.domain.User;
import com.app.fogether.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
		
	@GetMapping("/getUser")
	public Optional<User> getUser() {
		
		return userRepo.findById(3L);
		
	}
	
	@GetMapping("/createUser")
	public String createUser() {
		
		User user1 = new User();
		user1.setId(2L);
		user1.setName("Dikshit");
		
		userRepo.save(user1);
		return "User created";
	}
}

package com.app.fogether.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		
		userRepo.save(user);
		return user;
	}
}

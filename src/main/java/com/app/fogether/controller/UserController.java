package com.app.fogether.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.fogether.domain.User;
import com.app.fogether.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
		
	@GetMapping("/getUser/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		
		return userRepo.findById(id);
		
	}
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		
//		User user1 = new User();
//		user1.setId(3L);
//		user1.setName("Prashar");
		
		userRepo.save(user);
		return user;
	}
}

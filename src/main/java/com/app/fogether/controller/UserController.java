package com.app.fogether.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.fogether.domain.UserSignup;
import com.app.fogether.repository.UserRepository;
import com.app.fogether.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Cacheable(value = "users", key = "#id")
	@GetMapping("/getUser/{id}")
	public Optional<UserSignup> getUser(@PathVariable Long id) {
		return userService.getUser(id);
		
	}
	
	@PostMapping("/signupUser")
	public UserSignup signupUser() {
		UserSignup user = new UserSignup();
		user.setId(8L);
		user.setFirstName("test1");
		user.setMiddleName("test2");
		user.setLastName("test3");
		user.setEmail("test.com");
		user.setPhone(123456789L);
		user.setPassword("testuser");
		userService.signupUser(user);
		return user;
	}
}

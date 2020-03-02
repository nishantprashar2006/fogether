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

import com.app.fogether.domain.DatabaseSequence;
import com.app.fogether.domain.UserSignup;
import com.app.fogether.repository.UserRepository;
import com.app.fogether.service.SequenceGeneratorService;
import com.app.fogether.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SequenceGeneratorService sgs;
	
	@Cacheable(value = "users", key = "#id")
	@GetMapping("/getUser/{id}")
	public Optional<UserSignup> getUser(@PathVariable Long id) {
		return userService.getUser(id);
		
	}
	
	@PostMapping("/signupUser")
	public UserSignup signupUser(@RequestBody UserSignup user) {
		user.setId(sgs.generateSequence(UserSignup.SEQUENCE_NAME));
		userService.signupUser(user);
		return user;
	}
	
}

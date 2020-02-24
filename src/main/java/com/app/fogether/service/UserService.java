package com.app.fogether.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.fogether.domain.UserSignup;
import com.app.fogether.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public String passwordEncoder(String password, String salt) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashPassword = passwordEncoder.encode(password.concat(salt));
		System.out.println(hashPassword);
		
		return hashPassword;
	}

	public UserSignup signupUser(UserSignup user) {
		StringBuilder password = new StringBuilder(user.getPassword());
		String hashedPassword = passwordEncoder(password.toString(), password.reverse().toString());
		user.setPassword(hashedPassword);
		userRepo.save(user);
		return user;
	}

	public Optional<UserSignup> getUser(Long id) {
		return userRepo.findById(id);
	}
}

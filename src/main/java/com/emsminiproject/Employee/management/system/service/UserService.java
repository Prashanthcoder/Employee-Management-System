package com.emsminiproject.Employee.management.system.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emsminiproject.Employee.management.system.dto.RegisterRequestDTO;
import com.emsminiproject.Employee.management.system.entity.User;
import com.emsminiproject.Employee.management.system.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String register(RegisterRequestDTO registerRequest) {
		Optional<User> optional = userRepository.findByEmail(registerRequest.getEmail());
		if(optional.isPresent()) {
			return "email "+registerRequest.getEmail()+" is already registered";
		}
		
		User user = new User();
		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(registerRequest.getPassword());
		user.setRole("USER_ROLE");
		user.setVerified(false);
		userRepository.save(user);
		return "please enter otp to verify";
	}
}

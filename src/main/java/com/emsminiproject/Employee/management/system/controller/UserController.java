package com.emsminiproject.Employee.management.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsminiproject.Employee.management.system.dto.RegisterRequestDTO;
import com.emsminiproject.Employee.management.system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequestDTO registerRequest) {
		return userService.register(registerRequest);
	}
	
}

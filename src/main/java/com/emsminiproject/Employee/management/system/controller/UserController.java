package com.emsminiproject.Employee.management.system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emsminiproject.Employee.management.system.dto.RegisterRequestDTO;
import com.emsminiproject.Employee.management.system.dto.VerifyOtpRequest;
import com.emsminiproject.Employee.management.system.service.OtpService;
import com.emsminiproject.Employee.management.system.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;
	private final OtpService otpService;
	public UserController(UserService userService, OtpService otpService) {
		this.userService = userService;
		this.otpService = otpService;
	}

	@PostMapping("/register")
	public String register(@RequestBody RegisterRequestDTO registerRequest) {
		return userService.register(registerRequest);
	}

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		return otpService.verifyOtp(verifyOtpRequest);
	}
}

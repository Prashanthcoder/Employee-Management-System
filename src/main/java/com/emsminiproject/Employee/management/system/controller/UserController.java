package com.emsminiproject.Employee.management.system.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequestDTO registerRequest) {
		String result =  userService.register(registerRequest);
		if(result.contains("already registered")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("err", result));
		}
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(Map.of("message", result));
	}

	@PostMapping("/verify-otp")
	public ResponseEntity<Map<String, String>> verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		String result = otpService.verifyOtp(verifyOtpRequest);
		if(result.contains("already verified") || result.contains("expired") || result.contains("invalid otp")) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(Map.of("error", result));
		}
		
		return ResponseEntity
				.ok(Map.of("message", result));
		
	}
}

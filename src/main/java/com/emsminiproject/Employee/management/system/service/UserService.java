package com.emsminiproject.Employee.management.system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emsminiproject.Employee.management.system.dto.RegisterRequestDTO;
import com.emsminiproject.Employee.management.system.entity.User;
import com.emsminiproject.Employee.management.system.repository.UserRepository;
import com.emsminiproject.Employee.management.system.util.OtpGenerator;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final EmailService emailService;
	public UserService(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.passwordEncoder = passwordEncoder;
	}
	
	public String register(RegisterRequestDTO registerRequest) {
		Optional<User> optional = userRepository.findByEmail(registerRequest.getEmail());
		if(optional.isPresent()) {
			return "email "+registerRequest.getEmail()+" is already registered";
		}
		
		User user = new User();
		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setRole("USER_ROLE");
		user.setVerified(false);
		String otp = OtpGenerator.generateOtp();
		user.setOtp(otp);
		user.setOtpExpirationTime(LocalDateTime.now().plusMinutes(5));
		userRepository.save(user);
		
		emailService.sendOtp(registerRequest.getEmail(), otp);
		return "OTP sent to "+registerRequest.getEmail();
	}
}

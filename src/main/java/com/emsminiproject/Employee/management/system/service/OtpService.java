package com.emsminiproject.Employee.management.system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emsminiproject.Employee.management.system.dto.VerifyOtpRequest;
import com.emsminiproject.Employee.management.system.entity.User;
import com.emsminiproject.Employee.management.system.repository.UserRepository;

@Service
public class OtpService {

	private final UserRepository userRepository;
	public OtpService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String verifyOtp(VerifyOtpRequest verifyOtpRequest) {
		
		 Optional<User> optionalUser = userRepository.findByEmail(verifyOtpRequest.getEmail());
		 if(optionalUser.isPresent()) {
			 User user = optionalUser.get();
			 if(user.isVerified()) {
				 return "otp already verified";
			 }
			 
			 if(user.getOtp()==null || !user.getOtp().equals(verifyOtpRequest.getOtp())) {
				 return "invalid otp";
			 }
			 if(user.getOtpExpirationTime() == null || LocalDateTime.now().isAfter(user.getOtpExpirationTime())) {
				 return "OTP expired";
			 }
			 
			 
			 user.setVerified(true);
			 user.setOtp(null);
			 user.setOtpExpirationTime(null);
			 userRepository.save(user);
			 return "otp verified successfully";
		 }
		 return "email is not present";
	}
}

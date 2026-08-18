package com.emsminiproject.Employee.management.system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emsminiproject.Employee.management.system.dto.VerifyOtpRequest;
import com.emsminiproject.Employee.management.system.entity.User;
import com.emsminiproject.Employee.management.system.exception.InvalidOtpException;
import com.emsminiproject.Employee.management.system.exception.OtpAlreadyVerifiedException;
import com.emsminiproject.Employee.management.system.exception.OtpExpiredException;
import com.emsminiproject.Employee.management.system.exception.UserNotFoundException;
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
				 throw new OtpAlreadyVerifiedException("otp already verified");
			 }
			 
			 if(user.getOtp()==null || !user.getOtp().equals(verifyOtpRequest.getOtp())) {
				 throw new InvalidOtpException("invalid otp");
			 }
			 if(user.getOtpExpirationTime() == null || LocalDateTime.now().isAfter(user.getOtpExpirationTime())) {
				 throw new OtpExpiredException("otp expired");
			 }
			 user.setVerified(true);
			 user.setOtp(null);
			 user.setOtpExpirationTime(null);
			 userRepository.save(user);
			 return "otp verified successfully";
		 }
		throw new UserNotFoundException("User not found");
	}
}

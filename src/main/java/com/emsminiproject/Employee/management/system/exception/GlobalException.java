package com.emsminiproject.Employee.management.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException userNotFoundException){
		return new ResponseEntity(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidOtpException(InvalidOtpException invalidOtpException){
		return new ResponseEntity(invalidOtpException.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OtpAlreadyVerifiedException.class)
	public ResponseEntity<String> otpAlreadyVerifiedException(OtpAlreadyVerifiedException exception){
		return new ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OtpExpiredException.class)
	public ResponseEntity<String> otpExpiredException(OtpExpiredException otpExpired){
		return new ResponseEntity(otpExpired.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailIdNotFoundException.class)
	public ResponseEntity<String> emailIdNotFoundException(EmailIdNotFoundException emailException){
		return new ResponseEntity(emailException.getMessage(), HttpStatus.NOT_FOUND);
	}
}

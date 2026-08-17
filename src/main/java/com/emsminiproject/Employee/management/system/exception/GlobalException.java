package com.emsminiproject.Employee.management.system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException userNotFoundException){
		return new ResponseEntity(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> invalidData(MethodArgumentNotValidException exception){
		List<FieldError> messages = exception.getBindingResult().getFieldErrors();
		Map<String, String> map = new HashMap<String, String>();
		for(FieldError msg: messages) {
			map.put(msg.getField(), msg.getDefaultMessage());
		}
		return new ResponseEntity(map, HttpStatus.BAD_REQUEST);
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

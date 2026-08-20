package com.emsminiproject.Employee.management.system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VerifyOtpRequest {

	@Email(message = "please enter proper email id")
	@NotBlank(message = "Email cannot be null, empty or blank")
	private String email;
	@NotNull(message="otp cannot be null")
	private String otp;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
}

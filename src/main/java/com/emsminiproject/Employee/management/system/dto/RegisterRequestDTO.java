package com.emsminiproject.Employee.management.system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {
	
	@NotBlank(message="Name cannot be null, empty or blank")
	private String name;
	@Email(message="enter proper email id")
	private String email;
	@Size(min=6, message="Password length cannot be less than 6")
	@NotBlank(message="password cannot be null, empty or blank")
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

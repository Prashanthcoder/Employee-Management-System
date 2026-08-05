package com.emsminiproject.Employee.management.system.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	private final JavaMailSender javaMailSender;

	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendOtp(String toEmail, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("OTP verification for registration");
		message.setText("Otp for registration is "+otp+". Please do not share with anybody. Valid for 5 minutes.");
		javaMailSender.send(message);
	}
}

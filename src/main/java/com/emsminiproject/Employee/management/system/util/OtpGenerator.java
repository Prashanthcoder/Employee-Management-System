package com.emsminiproject.Employee.management.system.util;

import java.util.Random;

public class OtpGenerator {

	public static String generateOtp() {
		Random randome = new Random();
		int otp = 100000 + randome.nextInt(899999);
		return String.valueOf(otp);
	}
}

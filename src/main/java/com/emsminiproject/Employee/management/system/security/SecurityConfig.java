package com.emsminiproject.Employee.management.system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		http
		.csrf(csrf-> csrf.disable())
		.authorizeHttpRequests(auth-> auth.
				requestMatchers("/api/users/register", "api/users/verify-otp").permitAll()
				.requestMatchers("api/employees/**").authenticated()
				.anyRequest().authenticated()
				)
		.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}

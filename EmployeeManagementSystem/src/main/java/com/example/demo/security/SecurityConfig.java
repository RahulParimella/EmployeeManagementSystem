//package com.example.demo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class SecurityConfig {
//	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsManager() {
//		
//		UserDetails john= User.builder().username("john").password("{noop}rohith123").roles("EMPLOYEE").build();
//		UserDetails marry= User.builder().username("marry").password("{noop}test123").roles("EMPLOYEE","MANAGER").build();
//		UserDetails Sam= User.builder().username("Sam").password("{noop}test123").roles("EMPLOYEE","MANAGER","ADMIN").build();
//		
//		return new InMemoryUserDetailsManager(john,marry,Sam);
//		
//		
//	}
//	
//
//}

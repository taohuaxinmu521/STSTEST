package com.example.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.User;

@Configuration
public class Config {
	
	@Bean
	public User getUser() {
		return new User();
	}

}

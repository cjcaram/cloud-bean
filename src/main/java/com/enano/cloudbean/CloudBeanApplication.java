package com.enano.cloudbean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CloudBeanApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(CloudBeanApplication.class, args);
	}
	
  @Bean
  public PasswordEncoder getPasswordEncoder(){
      return new BCryptPasswordEncoder();
  } 
}

package com.enano.cloudbean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.servicies.UserService;

@SpringBootApplication
public class CloudBeanApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(CloudBeanApplication.class, args);
	}
	
	@Bean
  public CommandLineRunner setupDefaultUser(UserService service) {
	  if (service.getAllUsers().size() == 0) {
	    
      return args -> {
          service.save(new User(
                  "admin", //userName
                  "123", //password
                  1l,//role 
                  true//Active
          ));
      };
	  }
	  return null;
  }
  
  @Bean
  public PasswordEncoder getPasswordEncoder(){
      return new BCryptPasswordEncoder();
  } 
}

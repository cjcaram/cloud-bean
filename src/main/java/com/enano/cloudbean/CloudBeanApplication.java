package com.enano.cloudbean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.enano.cloudbean.dtos.UserRegistration;
import com.enano.cloudbean.entities.Role;
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
          service.save(new UserRegistration(
                  "admin", //userName
                  new Role("ADMIN", ""),//role 
                  null, // id
                  "123", //password
                  "123"//Active
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

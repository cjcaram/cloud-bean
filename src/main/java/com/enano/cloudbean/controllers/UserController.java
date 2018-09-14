package com.enano.cloudbean.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.UserProfile;
import com.enano.cloudbean.dtos.UserRegistration;
import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.servicies.UserService;
import com.enano.cloudbean.validations.UserValidation;

@RestController
public class UserController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private TokenStore tokenStore;
  
  @PostMapping(value = "/register")
  public String register(@RequestBody UserRegistration userRegistration) {
    String registrationMessage = "New User Created ";
    
    UserValidation userValidator = new UserValidation();
    if (userValidator.isNewUserValid(userRegistration)) {
      userService.save(getNewUser(userRegistration));
      registrationMessage += "Successfully!";
    }else {
      registrationMessage = userValidator.getErrorMessage();
    }
    return registrationMessage;
  }
  
  @GetMapping(value = "/users")
  public List<User> getUsers() {
    return userService.getAllUsers();
  }
  
  @GetMapping(value = "/getUserProfile")
  public UserProfile getUserProfile() {
    return userService.getUserProfileByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
  }
  
  @PostMapping(value = "/logoutCurrentUser")
  public void logout(@RequestBody String accessToken){
    tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken.substring(0, accessToken.length()-1)));
  }

  private User getNewUser(UserRegistration userRegistration) {
    User newUser = new User();
    newUser.setActive(true);
    newUser.setModificationDate(new Date());
    newUser.setRolId(2l);
    newUser.setPassword(userRegistration.getPassword());
    newUser.setUserName(userRegistration.getUsername());
    return newUser;
  }
  
  
}

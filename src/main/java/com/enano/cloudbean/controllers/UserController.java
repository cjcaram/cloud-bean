package com.enano.cloudbean.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.HttpErrorBody;
import com.enano.cloudbean.dtos.UserProfile;
import com.enano.cloudbean.dtos.UserRegistration;
import com.enano.cloudbean.entities.Role;
import com.enano.cloudbean.entities.User;
import com.enano.cloudbean.servicies.RoleService;
import com.enano.cloudbean.servicies.UserService;
import com.enano.cloudbean.validations.UserValidation;

@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private RoleService roleService;
  
  @Autowired
  private TokenStore tokenStore;
  
  private HttpErrorBody httpErrorBody;
  private static final Logger LOGGER = LogManager.getLogger(UserController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> register(@RequestBody UserRegistration userRegistration) {
    ResponseEntity<?> response = null;
    List<Role> roleList = new ArrayList<>();
    UserValidation userValidator = new UserValidation(userRegistration);
    try {
      roleList =  roleService.getAllRoles();
      userValidator.setRoles(roleList);
      if (isEdition(userRegistration) ) {
        response = editUser(userRegistration, userValidator);
      } else {
        response = addNewUser(userRegistration, userValidator);
      }
    } catch (Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, userValidator.getErrorMessage());
      response = new ResponseEntity<>(httpErrorBody, HttpStatus.INTERNAL_SERVER_ERROR);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }

  private ResponseEntity<?> addNewUser(UserRegistration userRegistration, UserValidation userValidator)
      throws Exception {
    userValidator.checkIfNewUserIsValid();
    userRegistration.setId(null);
    return ResponseEntity.ok(userService.save(userRegistration));
  }

  private ResponseEntity<?> editUser(UserRegistration userRegistration,
      UserValidation userValidator) throws Exception {
    ResponseEntity<?> response;
    if (isPswrdUpdateRequired(userRegistration)) {
      userValidator.checkIfNewUserIsValid();
      response = ResponseEntity.ok(userService.updateUserWithNoPswrd(userRegistration));
    } else {
      userValidator.checkIfNewUserIsValid(true);
      response = ResponseEntity.ok(userService.updateUser(userRegistration));
    }
    return response;
  }

  private boolean isEdition(UserRegistration userRegistration) {
    return userRegistration.getId() != null && userRegistration.getId() > 0;
  }
  
  private boolean isPswrdUpdateRequired(UserRegistration userRegistration) {
    return (!userRegistration.getPassword().isEmpty() && !userRegistration.getPasswordConfirmation().isEmpty());
  }
  
  @GetMapping(value = "/users")
  public List<User> getUsers() {
    return userService.getAllUsers();
  }
  
  @GetMapping(value = "/activeUsers")
  public List<User> getActiveUsers() {
    return userService.getActiveUsers();
  }
  
  @GetMapping(value = "/getUserProfile")
  public UserProfile getUserProfile() {
    return userService.getUserProfileByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
  }
  
  @GetMapping(value = "/deleteUser")
  public User setUserAsInactived(@PathVariable int id) {
    return userService.setUserAsInactived(id);
  }
  
  @PostMapping(value = "/logoutCurrentUser")
  public void logout(@RequestBody String accessToken){
    tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken.substring(0, accessToken.length()-1)));
  }
}

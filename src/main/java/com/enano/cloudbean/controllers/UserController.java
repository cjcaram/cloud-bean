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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.HttpErrorBody;
import com.enano.cloudbean.dtos.UserProfile;
import com.enano.cloudbean.dtos.UserDto;
import com.enano.cloudbean.entities.Role;
import com.enano.cloudbean.services.RoleService;
import com.enano.cloudbean.services.UserService;
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
  public ResponseEntity<?> register(@RequestBody UserDto userRegistration) {
    ResponseEntity<?> response = null;
    List<Role> roleList = new ArrayList<>();
    UserValidation userValidator = new UserValidation(userRegistration);
    try {
      roleList =  roleService.getAllRoles();
      userValidator.setRoles(roleList);
      if (ZUtils.isEdition(userRegistration.getId())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        response = editUser(userRegistration, userValidator);
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        response = addNewUser(userRegistration, userValidator);
      }
    } catch (Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, userValidator.getErrorMessage());
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }

  private ResponseEntity<?> addNewUser(UserDto userRegistration, UserValidation userValidator)
      throws Exception {
    userValidator.checkIfNewUserIsValid();
    userRegistration.setId(null);
    return ResponseEntity.ok(userService.save(userRegistration));
  }

  private ResponseEntity<?> editUser(UserDto userRegistration,
      UserValidation userValidator) throws Exception {
    ResponseEntity<?> response;
    if (isPswrdUpdateRequired(userRegistration)) {
      userValidator.checkIfNewUserIsValid();
      response = ResponseEntity.ok(userService.updateUser(userRegistration));
    } else {
      userValidator.checkIfNewUserIsValid(true);
      response = ResponseEntity.ok(userService.updateUserWithNoPswrd(userRegistration));
    }
    return response;
  }

  private boolean isPswrdUpdateRequired(UserDto userRegistration) {
    return (!userRegistration.getPassword().isEmpty() && !userRegistration.getPasswordConfirmation().isEmpty());
  }
  
  
  @GetMapping(value = "/activeUsers")
  public List<UserDto> getActiveUsers() {
    return userService.getActiveUsers();
  }
  
  @GetMapping(value = "/getUserProfile")
  public UserProfile getUserProfile() {
    return userService.getUserProfileByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
  }
  
  @DeleteMapping(value = "/disableUser")
  public ResponseEntity<?> setUserAsInactived(@RequestBody UserDto userToDisable) {
    ResponseEntity<?> response = null;
    Integer id = userToDisable.getId();
    try {
      response = ResponseEntity.ok(userService.setUserAsInactived(id));
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Trying to Disable User with id " + id);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
  
  @PostMapping(value = "/logoutCurrentUser")
  public void logout(@RequestBody String accessToken){
    tokenStore.removeAccessToken(tokenStore.readAccessToken(accessToken.substring(0, accessToken.length()-1)));
  }
}

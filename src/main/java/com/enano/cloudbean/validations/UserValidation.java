package com.enano.cloudbean.validations;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.enano.cloudbean.dtos.UserDto;
import com.enano.cloudbean.entities.Role;

public class UserValidation {
  
  private UserDto user;
  private List<String> errorMessage = new ArrayList<>();
  private boolean isValidUser = true;
  private List<Role> roleList;

  public UserValidation(UserDto userRegistration) {
    this.user = userRegistration;
  }
  
  public UserValidation(UserDto userRegistration, List<Role> allRoles) {
    this.roleList = allRoles;
    this.user = userRegistration;
  }

  public List<String> getErrorMessage() {
    return errorMessage;
  }
  
  public void setRoles(List<Role> allRoles) {
    this.roleList = allRoles;
  }
  
  public void checkIfNewUserIsValid() throws Exception {
    checkIfNewUserIsValid(false);
  }
  
  public void checkIfNewUserIsValid(boolean skipPswdCheck) throws Exception {
    if (user.getUsername() == null || user.getUsername().isEmpty()) {
      errorMessage.add("User Name can not be empty.");
      isValidUser = false;
    } else if (!roleList.contains(user.getRole())) {
      errorMessage.add("The specified role does not exist.");
      isValidUser = false;
    } else if (user.getCompany().getId() == null || user.getCompany().getId() < 0) {
      errorMessage.add("Company can not be empty.");
      isValidUser = false;
    } else if (!roleList.contains(user.getRole())) {
      errorMessage.add("The specified role does not exist.");
      isValidUser = false;
    } else if (!skipPswdCheck && user.getPassword().isEmpty()) {
      errorMessage.add("Password can not be empty.");
      isValidUser = false;
    } else if (!skipPswdCheck &&  !user.getPassword().equals(user.getPasswordConfirmation())){
      errorMessage.add("Password and Confirmation Password are not equals.");
      isValidUser = false;
    } else {
      Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
      if (pattern.matcher(user.getUsername()).find()) {
        errorMessage.add("No Special Characters are allowed in the userName.");
        isValidUser = false;
      }
    }
    if (!isValidUser) {
      throw new Exception("The user not meet the min requirements. ");
    }
  }
}

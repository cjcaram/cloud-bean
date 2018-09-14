package com.enano.cloudbean.validations;

import java.util.regex.Pattern;

import com.enano.cloudbean.dtos.UserRegistration;

public class UserValidation {
  
  private String errorMessage = "Invalid User. ";
  
  public String getErrorMessage() {
    return errorMessage;
  }
  
  public boolean isNewUserValid(UserRegistration userRegistration) {
    boolean isValidUser = true;
    if (userRegistration.getUsername().isEmpty()) {
      this.errorMessage += "User Name can not be empty.";
      isValidUser = false;
    } else if (userRegistration.getPassword().isEmpty()) {
      this.errorMessage += "Password can not be empty.";
      isValidUser = false;
    } else if (!userRegistration.getPassword().equals(userRegistration.getPasswordConfirmation())){
      this.errorMessage += "Password and Confirmation Password are not equals.";
      isValidUser = false;
    } else {
      Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
      if (pattern.matcher(userRegistration.getUsername()).find()) {
        this.errorMessage += "No Special Characters are allowed in the userName.";
        isValidUser = false;
      }
      
    }
    return isValidUser;
    
  }

}

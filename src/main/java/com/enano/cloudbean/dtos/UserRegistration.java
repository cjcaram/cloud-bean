package com.enano.cloudbean.dtos;

public class UserRegistration extends UserProfile{
  private String password;
  private String passwordConfirmation;
  
  public UserRegistration() {
  }

  public UserRegistration(String username, String role, String password, String passwordConfirmation) {
    super(username, role);
    this.password = password;
    this.passwordConfirmation = passwordConfirmation;
  }

  public String getPassword() {
      return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }

  public String getPasswordConfirmation() {
      return passwordConfirmation;
  }

  public void setPasswordConfirmation(String passwordConfirmation) {
      this.passwordConfirmation = passwordConfirmation;
  }
}

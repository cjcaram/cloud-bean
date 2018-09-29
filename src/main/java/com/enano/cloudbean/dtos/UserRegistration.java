package com.enano.cloudbean.dtos;

import com.enano.cloudbean.entities.Role;

public class UserRegistration extends UserProfile{
  private Integer id;
  private String password;
  private String passwordConfirmation;
  
  public UserRegistration() {
  }

  public UserRegistration(String username, Role role, Integer id,String password, String passwordConfirmation) {
    super(username, role);
    this.id = id;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}

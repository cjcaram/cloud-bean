package com.enano.cloudbean.dtos;

import com.enano.cloudbean.entities.Role;

public class UserDto extends UserProfile{
  private Integer id;
  private CompanyDto company;
  private String password;
  private String passwordConfirmation;
    
  public UserDto() {
  }

  public UserDto(String username, Role role, Integer id,String password, String passwordConfirmation,
      CompanyDto company) {
    super(username, role);
    this.id = id;
    this.password = password;
    this.passwordConfirmation = passwordConfirmation;
    this.company = company;
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

  public CompanyDto getCompany() {
    return company;
  }

  public void setCompany(CompanyDto company) {
    this.company = company;
  }
}

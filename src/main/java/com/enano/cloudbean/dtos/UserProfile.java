package com.enano.cloudbean.dtos;

import com.enano.cloudbean.entities.Role;

public class UserProfile {
  private String username;
  private Role role;
  
  public UserProfile () {}
  
  public UserProfile(String username, Role role) {
    this.username = username;
    this.role = role;
  }
  
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

}

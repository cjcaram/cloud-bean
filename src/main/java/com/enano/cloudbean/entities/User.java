package com.enano.cloudbean.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(name= "USER_NAME")
  private String userName;

  @JsonIgnore
  @Column(name= "PSWD")
  private String password;
  
  @Column (name = "MODIFICATION_DATE")
  private Date modificationDate;
  
  @Column (name = "ROLE_ID")
  private Long rolId;
  
  @Column (name = "ACTIVE")
  private boolean active;

  public Long getId() {
    return id;
  }
  
  public User() {
    
  }
  
  public User(Long id, String userName, String password, Date modificationDate, Long rolId,
      boolean active) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.modificationDate = modificationDate;
    this.rolId = rolId;
    this.active = active;
  }
  
  public User(String userName, String password, Long rolId,
      boolean active) {
    this.userName = userName;
    this.password = password;
    this.modificationDate = new Date();
    this.rolId = rolId;
    this.active = active;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public Date getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }

  public Long getRolId() {
    return rolId;
  }

  public void setRolId(Long rolId) {
    this.rolId = rolId;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}


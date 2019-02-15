package com.enano.cloudbean.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
  
  @Column (name = "ACTIVE")
  private boolean active;

  @OneToOne
  @JoinColumn(name = "ROLE_ID")
  private Role role;
  
  @OneToOne
  @JoinColumn(name = "COMPANY_ID")
  private ComercialEntity company;
  
  public User() {
    
  }
  
  public User(Long id, String userName, String password, Date modificationDate, Role role,
      boolean active, ComercialEntity company) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.modificationDate = modificationDate;
    this.role = role;
    this.active = active;
    this.company = company;
  }
  
  public User(String userName, String password, Role role,
      boolean active, ComercialEntity company) {
    this.userName = userName;
    this.password = password;
    this.modificationDate = new Date();
    this.role = role;
    this.active = active;
    this.company = company;
  }
  
  public Long getId() {
    return id;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public ComercialEntity getCompany() {
    return company;
  }

  public void setCompany(ComercialEntity company) {
    this.company = company;
  }
}


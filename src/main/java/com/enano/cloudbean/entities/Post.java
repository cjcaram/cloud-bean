package com.enano.cloudbean.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "TITLE")
  private String title;
  @Column(name = "BODY")
  private String body;
  @Column(name = "CREATION_DATE")
  private Date dateCreated;
  
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User creator;
  
  public Post() {
    
  }
  
  public Post(Long id, String title, String body, Date dateCreated, User creator) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.dateCreated = dateCreated;
    this.creator = creator;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }
  public Date getDateCreated() {
    return dateCreated;
  }
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }
  
  
  
}

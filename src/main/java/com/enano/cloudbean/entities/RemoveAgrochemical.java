package com.enano.cloudbean.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "AGROQUIMICO_RETIRO")
public class RemoveAgrochemical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="ORDEN_TRABAJO")
  private String workOrderId;
  @Column(name="CANTIDAD")
  private int amount;
  @Column(name="FECHA")
  private Date date;
  @Column(name="AGROQUIMICO_ID")
  private Long agrochemicalId;
  
  public RemoveAgrochemical() {
  }
  
  public RemoveAgrochemical(Long id, String workOrderId, int amount, Date date, Long agrochemicalId) {
    this.id = id;
    this.workOrderId = workOrderId;
    this.amount = amount;
    this.date = date;
    this.agrochemicalId = agrochemicalId;
  }
  
  public RemoveAgrochemical(String workOrderId, Long agrochemicalId, int amount) {
    this.workOrderId = workOrderId;
    this.amount = amount;
    this.date = new Date();
    this.agrochemicalId = agrochemicalId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getWorkOrderId() {
    return workOrderId;
  }

  public void setWorkOrderId(String workOrderId) {
    this.workOrderId = workOrderId;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Long getAgrochemicalId() {
    return agrochemicalId;
  }

  public void setAgrochemicalId(Long agrochemicalId) {
    this.agrochemicalId = agrochemicalId;
  }
}

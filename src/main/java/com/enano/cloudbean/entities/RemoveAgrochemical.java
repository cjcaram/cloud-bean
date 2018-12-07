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

@Entity
@Table(name= "AGROQUIMICO_RETIRO")
public class RemoveAgrochemical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name="ORDEN_TRABAJO")
  private String workOrderId;
  @Column(name="CANTIDAD")
  private int amount;
  @Column(name="FECHA")
  private Date date;
  @ManyToOne
  @JoinColumn(name="AGROQUIMICO_ID")
  private Agrochemical agrochemical;
  
  public RemoveAgrochemical() {
  }
  
  public RemoveAgrochemical(int id, String workOrderId, int amount, Date date, Agrochemical agrochemical) {
    this.id = id;
    this.workOrderId = workOrderId;
    this.amount = amount;
    this.date = date;
    this.agrochemical = agrochemical;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public Agrochemical getAgrochemical() {
    return agrochemical;
  }

  public void setAgrochemical(Agrochemical agrochemical) {
    this.agrochemical = agrochemical;
  }
}

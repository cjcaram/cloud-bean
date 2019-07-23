package com.enano.cloudbean.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
  private Float amount;
  @Column(name="FECHA")
  private Date date;
  @OneToOne(cascade = CascadeType.PERSIST, optional = true)
  @JoinColumn(name="AGROQUIMICO_ID", nullable = true)
  private Agrochemical agrochemical;
  
  public RemoveAgrochemical() {
  }
  
  public RemoveAgrochemical(Long id, String workOrderId, Float amount, Date date, Agrochemical agrochemical) {
    this.id = id;
    this.workOrderId = workOrderId;
    this.amount = amount;
    this.date = date;
    this.agrochemical = agrochemical;
  }
  
  public RemoveAgrochemical(String workOrderId, Agrochemical agrochemical, Float amount) {
    this.date = new Date();
    this.workOrderId = workOrderId;
    this.amount = amount;
    this.agrochemical = agrochemical;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
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

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
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

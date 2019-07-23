package com.enano.cloudbean.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="aplicacion")
public class Application {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="APLICACION_NRO")
  private Integer applicationNumber;
  
  @OneToOne
  @JoinColumn(name="APPLICACION_TIPO")
  private AgrochemicalAppType applicationType;
  
  @OneToOne
  @JoinColumn(name="LOTE_ID")
  private LandBatch landBatch;
  
  @Column(name="CANT_HA")
  private Integer haAmount;
  
  @Column(name="FECHA_APLICACION")
  private Date applicationDate;
  
  @OneToMany(targetEntity = AgrochemicalApplication.class, mappedBy = "application" )
  private Set<AgrochemicalApplication> items;

  public Application() {
  }

  public Application(Long id, Integer applicationNumber, AgrochemicalAppType applicationType,
      LandBatch landBatch, Integer haAmount, Date applicationDate) {
    this.id = id;
    this.applicationNumber = applicationNumber;
    this.applicationType = applicationType;
    this.landBatch = landBatch;
    this.haAmount = haAmount;
    this.applicationDate = applicationDate;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getApplicationNumber() {
    return applicationNumber;
  }

  public void setApplicationNumber(Integer applicationNumber) {
    this.applicationNumber = applicationNumber;
  }

  public AgrochemicalAppType getApplicationType() {
    return applicationType;
  }

  public void setApplicationType(AgrochemicalAppType applicationType) {
    this.applicationType = applicationType;
  }

  public LandBatch getLandBatch() {
    return landBatch;
  }

  public void setLandBatch(LandBatch landBatch) {
    this.landBatch = landBatch;
  }

  public Integer getHaAmount() {
    return haAmount;
  }

  public void setHaAmount(Integer haAmount) {
    this.haAmount = haAmount;
  }

  public Date getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(Date applicationDate) {
    this.applicationDate = applicationDate;
  }

  public Set<AgrochemicalApplication> getItems() {
    return items;
  }

  public void setItems(Set<AgrochemicalApplication> items) {
    this.items = items;
  }
}


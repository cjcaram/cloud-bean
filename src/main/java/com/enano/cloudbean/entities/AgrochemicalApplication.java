package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AGROQUIMICO_APLICACION")
public class AgrochemicalApplication {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @Column(name="APLICACION_NRO")
  private int applicationNumber;
  
  @ManyToOne
  @JoinColumn(name="APPLICACION_TIPO")
  private AgrochemicalAppType applicationType;
  
  @ManyToOne
  @JoinColumn(name="ARGROQUIMICO_ID")
  private Agrochemical agrochemical;
  
  @ManyToOne
  @JoinColumn(name="LOTE_ID")
  private LandBatch landBatch;
  
  @Column(name="CANT_HA")
  private int haAmount;
  
  @Column(name="CANT_HA")
  private Double dosage;

  public AgrochemicalApplication() {
  }
  
  public AgrochemicalApplication(Long id, int applicationNumber,
      AgrochemicalAppType applicationType, Agrochemical agrochemical, LandBatch landBatch,
      int haAmount, Double dosage) {
    this.id = id;
    this.applicationNumber = applicationNumber;
    this.applicationType = applicationType;
    this.agrochemical = agrochemical;
    this.landBatch = landBatch;
    this.haAmount = haAmount;
    this.dosage = dosage;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getApplicationNumber() {
    return applicationNumber;
  }

  public void setApplicationNumber(int applicationNumber) {
    this.applicationNumber = applicationNumber;
  }

  public AgrochemicalAppType getApplicationType() {
    return applicationType;
  }

  public void setApplicationType(AgrochemicalAppType applicationType) {
    this.applicationType = applicationType;
  }

  public Agrochemical getAgrochemical() {
    return agrochemical;
  }

  public void setAgrochemical(Agrochemical agrochemical) {
    this.agrochemical = agrochemical;
  }

  public LandBatch getLandBatch() {
    return landBatch;
  }

  public void setLandBatch(LandBatch landBatch) {
    this.landBatch = landBatch;
  }

  public int getHaAmount() {
    return haAmount;
  }

  public void setHaAmount(int haAmount) {
    this.haAmount = haAmount;
  }

  public Double getDosage() {
    return dosage;
  }

  public void setDosage(Double dosage) {
    this.dosage = dosage;
  }
}

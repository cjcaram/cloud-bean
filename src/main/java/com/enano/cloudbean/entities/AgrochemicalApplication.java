package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="AGROQUIMICO_APLICACION")
public class AgrochemicalApplication {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  @OneToOne
  @JoinColumn(name="ARGROQUIMICO_ID")
  private Agrochemical agrochemical;
  
  @ManyToOne
  @JoinColumn(name="APLICACION_ID")
  @JsonIgnore
  private Application application;
  
  @Column(name="DOSIS")
  private Float dosage;
  
  public AgrochemicalApplication() {
  }

  public AgrochemicalApplication(Long id, Agrochemical agrochemical, Application application,
      Float dosage) {
    this.id = id;
    this.agrochemical = agrochemical;
    this.application = application;
    this.dosage = dosage;
  }
  
  public AgrochemicalApplication(Agrochemical agrochemical, Application application,
      Float dosage) {
    this.agrochemical = agrochemical;
    this.application = application;
    this.dosage = dosage;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Agrochemical getAgrochemical() {
    return agrochemical;
  }

  public void setAgrochemical(Agrochemical agrochemical) {
    this.agrochemical = agrochemical;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  public Float getDosage() {
    return dosage;
  }

  public void setDosage(Float dosage) {
    this.dosage = dosage;
  }

}

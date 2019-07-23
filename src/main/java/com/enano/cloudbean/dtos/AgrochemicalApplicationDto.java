package com.enano.cloudbean.dtos;

import com.enano.cloudbean.entities.Agrochemical;
import com.enano.cloudbean.entities.Application;

public class AgrochemicalApplicationDto {
  
  private Long id;
  private Agrochemical agrochemical;
  private Application application;
  private Float dosage;
  
  public AgrochemicalApplicationDto () {
  }
  
  public AgrochemicalApplicationDto(Long id, Agrochemical agrochemical, Application application,
      Float dosage) {
    this.id = id;
    this.agrochemical = agrochemical;
    this.application = application;
    this.dosage = dosage;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
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

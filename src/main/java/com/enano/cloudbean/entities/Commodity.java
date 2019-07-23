package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "mercaderia")
public class Commodity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  @JoinColumn(name="tipo_calidad_id", nullable = true)
  private QualityType qualityType;
  @OneToOne
  @JoinColumn(name="tipo_bolsa_id", nullable = true)
  private PackagingType packagingType;
  @Column(name="cantidad_bulto")
  private Double bagQuantity;
  @Column(name="cantidad_kg")
  private Integer amount;
  @Column(name="ubicacion")
  private String locationInPlant;
  @Column(name="gramaje")
  private Integer gramaje;
  @Column(name="obs")
  private String obs;
  @Column(name="proceso_id")
  private Long processId;

  public Commodity() {
  }
  
  public Commodity(Long id, QualityType qualityType, PackagingType packagingType,
      Double bagQuantity, Integer amount, String locationInPlant, Integer gramaje, String obs,
      Long processId) {
    this.id = id;
    this.qualityType = qualityType;
    this.packagingType = packagingType;
    this.bagQuantity = bagQuantity;
    this.amount = amount;
    this.locationInPlant = locationInPlant;
    this.gramaje = gramaje;
    this.obs = obs;
    this.processId = processId;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public QualityType getQualityType() {
    return qualityType;
  }

  public void setQualityType(QualityType qualityType) {
    this.qualityType = qualityType;
  }

  public PackagingType getPackagingType() {
    return packagingType;
  }

  public void setPackagingType(PackagingType packagingType) {
    this.packagingType = packagingType;
  }

  public Double getBagQuantity() {
    return bagQuantity;
  }

  public void setBagQuantity(Double bagQuantity) {
    this.bagQuantity = bagQuantity;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getLocationInPlant() {
    return locationInPlant;
  }

  public void setLocationInPlant(String locationInPlant) {
    this.locationInPlant = locationInPlant;
  }

  public Integer getGramaje() {
    return gramaje;
  }

  public void setGramaje(Integer gramaje) {
    this.gramaje = gramaje;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public Long getProcessId() {
    return processId;
  }

  public void setProcessId(Long processId) {
    this.processId = processId;
  }

  @Override
  public String toString() {
    return "Commodity [id=" + id + ", qualityType=" + qualityType + ", packagingType=" + 
        packagingType + ", bagQuantity=" + bagQuantity + ", amount=" + amount
        + ", locationInPlant=" + locationInPlant + ", gramaje=" + gramaje + ", obs=" + obs + "]";
  }
}

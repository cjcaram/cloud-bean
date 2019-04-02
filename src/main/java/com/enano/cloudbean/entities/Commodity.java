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
  @Column(name="propietario")
  private Long owner;
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
  @OneToOne
  @JoinColumn(name = "grano_especie_id")
  private GrainType grainType;
  
  public Commodity() {
  }
  
  public Commodity(Long id, Long owner, QualityType qualityType, PackagingType packagingType,
      Double bagQuantity, Integer amount, String locationInPlant, Integer gramaje, String obs,
      Long processId, GrainType grainType) {
    this.id = id;
    this.owner = owner;
    this.qualityType = qualityType;
    this.packagingType = packagingType;
    this.bagQuantity = bagQuantity;
    this.amount = amount;
    this.locationInPlant = locationInPlant;
    this.gramaje = gramaje;
    this.obs = obs;
    this.processId = processId;
    this.grainType = grainType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOwner() {
    return owner;
  }

  public void setOwner(Long owner) {
    this.owner = owner;
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

  public GrainType getGrainType() {
    return grainType;
  }

  public void setGrainType(GrainType grainType) {
    this.grainType = grainType;
  }
}

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
@Table(name = "AGROQUIMICO")
public class Agrochemical {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @Column (name = "NOMBRE")
  private String nombre;
  
  @Column (name = "NOTA")
  private String nota;
  
  @Column (name = "CANTIDAD")
  private Integer amount;
 
  @Column (name = "UNIDAD_MEDIDA")
  private int measurementUnit;
  
  @Column (name = "FECHA_MODIFICACION")
  private Date modificationDate;
  
  @Column (name = "FECHA_VENCIMIENTO")
  private Date expirationDate;
  
  @Column (name = "FECHA_COMPRA")
  private Date purchaseDate;
  
  @Column (name = "CATEGORIA")
  private int categoria;
  
  @Column (name = "PRINCIPIO_ACTIVO")
  private String activePrincipie;
  
  @Column (name = "CONCENTRACION_PA")
  private float principeActiveConcentration;
  
  @Column (name = "PRECIO")
  private Double price;
  
  @Column (name = "LABORATORIO")
  private String laboratory;
  
  @Column (name = "FACTURA")
  private String bill;
  
  @Column (name = "LOTE_CODIGO")
  private String batchCode;
 
  @ManyToOne
  @JoinColumn(name = "AGROQUIMICO_TIPO", nullable = true)
  private AgrochemicalType agrochemicalType;
  
  public Agrochemical() { }

  public Agrochemical(Long id, String nombre, String nota, Integer amount, int measurementUnit,
      Date modificationDate, Date expirationDate, Date purchaseDate, int categoria,
      String activePrincipie, float principeActiveConcentration, Double price, String laboratory,
      String bill, String batchCode, AgrochemicalType agrochemicalType) {
    this.id = id;
    this.nombre = nombre;
    this.nota = nota;
    this.amount = amount;
    this.measurementUnit = measurementUnit;
    this.modificationDate = modificationDate;
    this.expirationDate = expirationDate;
    this.purchaseDate = purchaseDate;
    this.categoria = categoria;
    this.activePrincipie = activePrincipie;
    this.principeActiveConcentration = principeActiveConcentration;
    this.price = price;
    this.laboratory = laboratory;
    this.bill = bill;
    this.batchCode = batchCode;
    this.agrochemicalType = agrochemicalType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNota() {
    return nota;
  }

  public void setNota(String nota) {
    this.nota = nota;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public int getMeasurementUnit() {
    return measurementUnit;
  }

  public void setMeasurementUnit(int measurementUnit) {
    this.measurementUnit = measurementUnit;
  }

  public Date getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public int getCategoria() {
    return categoria;
  }

  public void setCategoria(int categoria) {
    this.categoria = categoria;
  }

  public String getActivePrincipie() {
    return activePrincipie;
  }

  public void setActivePrincipie(String activePrincipie) {
    this.activePrincipie = activePrincipie;
  }

  public float getPrincipeActiveConcentration() {
    return principeActiveConcentration;
  }

  public void setPrincipeActiveConcentration(float principeActiveConcentration) {
    this.principeActiveConcentration = principeActiveConcentration;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getLaboratory() {
    return laboratory;
  }

  public void setLaboratory(String laboratory) {
    this.laboratory = laboratory;
  }

  public String getBill() {
    return bill;
  }

  public void setBill(String bill) {
    this.bill = bill;
  }

  public String getBatchCode() {
    return batchCode;
  }

  public void setBatchCode(String batchCode) {
    this.batchCode = batchCode;
  }

  public AgrochemicalType getAgrochemicalType() {
    return agrochemicalType;
  }

  public void setAgrochemicalType(AgrochemicalType agrochemicalType) {
    this.agrochemicalType = agrochemicalType;
  }
}
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
@Table(name= "FINCA_LOTE")
public class LandBatch {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name="FINCA_ID")
  private Location land;
  
  @Column(name="NOMBRE")
  private String name;
  
  @Column(name="CANT_HA")
  private String haAmount;
  
  @Column(name="NOTA")
  private String note;
  
  public LandBatch() {
  }
  
  public LandBatch(Long id, Location land, String name, String haAmount, String note) {
    this.id = id;
    this.land = land;
    this.name = name;
    this.haAmount = haAmount;
    this.note = note;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Location getLand() {
    return land;
  }

  public void setLand(Location land) {
    this.land = land;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getHaAmount() {
    return haAmount;
  }

  public void setHaAmount(String haAmount) {
    this.haAmount = haAmount;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}

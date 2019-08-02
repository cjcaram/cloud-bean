package com.enano.cloudbean.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="proceso")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="proceso_numero")
    private int processNumber;
    @Column(name="nombre_referencia")
    private String referenceName;
    @Column(name="fecha")
    private Date date;
    @JsonIgnore
    @Column(name="fecha_modificacion")
    private Date modificationDate;
    @Column(name="obs")
    private String obs;
    
    public Process(){
    }
    
    public Process(Long id, int processNumber, String referenceName, Date date,
        Date modificationDate, String obs) {
      this.id = id;
      this.processNumber = processNumber;
      this.referenceName = referenceName;
      this.date = date;
      this.modificationDate = modificationDate;
      this.obs = obs;
    }

    public Long getId() {
      return (id != null && id > 0) ? id : null;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public int getProcessNumber() {
      return processNumber;
    }

    public void setProcessNumber(int processNumber) {
      this.processNumber = processNumber;
    }

    public String getReferenceName() {
      return referenceName;
    }

    public void setReferenceName(String referenceName) {
      this.referenceName = referenceName;
    }

    public Date getDate() {
      return date;
    }

    public void setDate(Date date) {
      this.date = date;
    }

    public Date getModificationDate() {
      return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
      this.modificationDate = modificationDate;
    }

    public String getObs() {
      return obs;
    }

    public void setObs(String obs) {
      this.obs = obs;
    }

    @Override
    public String toString() {
      return "Process [id=" + id + ", processNumber=" + processNumber + ", referenceName="
          + referenceName + ", date=" + date + ", modificationDate=" + modificationDate + ", obs="
          + obs + "]";
    }
}
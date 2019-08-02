package com.enano.cloudbean.dtos;

import java.util.Date;

public class BasicIncomeInfoDto {
  
  private Long id;
  private String gramaje;
  private Float caida;
  private String grano;
  private int ingresoNro;
  private int kilogramos;
  private String procedencia;
  private String destinatario;
  private String cp;
  private Date downloadDate;
  
  public BasicIncomeInfoDto () {
  }
  
  public BasicIncomeInfoDto(Long id, String gramaje, Float caida, String grano, int ingresoNro, 
      int kilogramos, String procedencia, String destinatario, String cp, Date downloadDate) {
    this.id = id;
    this.gramaje = gramaje;
    this.caida = caida;
    this.grano = grano;
    this.ingresoNro = ingresoNro;
    this.kilogramos = kilogramos;
    this.procedencia = procedencia;
    this.destinatario = destinatario;
    this.cp = cp;
    this.setDownloadDate(downloadDate);
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGramaje() {
    return gramaje;
  }

  public void setGramaje(String gramaje) {
    this.gramaje = gramaje;
  }

  public String getGrano() {
    return grano;
  }

  public void setGrano(String grano) {
    this.grano = grano;
  }

  public int getIngresoNro() {
    return ingresoNro;
  }

  public void setIngresoNro(int ingresoNro) {
    this.ingresoNro = ingresoNro;
  }

  public int getKilogramos() {
    return kilogramos;
  }

  public void setKilogramos(int kilogramos) {
    this.kilogramos = kilogramos;
  }

  public String getProcedencia() {
    return procedencia;
  }

  public void setProcedencia(String procedencia) {
    this.procedencia = procedencia;
  }

  public String getDestinatario() {
    return destinatario;
  }

  public void setDestinatario(String destinatario) {
    this.destinatario = destinatario;
  }

  public Float getCaida() {
    return caida;
  }

  public void setCaida(Float caida) {
    this.caida = caida;
  }
  
  public String getCp() {
    return cp;
  }

  public void setCp(String cp) {
    this.cp = cp;
  }

  public Date getDownloadDate() {
    return downloadDate;
  }

  public void setDownloadDate(Date downloadDate) {
    this.downloadDate = downloadDate;
  }
}

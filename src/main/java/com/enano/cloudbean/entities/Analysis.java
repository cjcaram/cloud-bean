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
@Table(name= "analisis")
public class Analysis {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="zaranda")
  private float zaranda;
  @Column(name="caida_zaranda")
  private float caidaZaranda;
  @Column(name="incomestible")
  private float incomestible;
  @Column(name="terron")
  private float terron;
  @Column(name="manchado")
  private float manchado;
  @Column(name="partido")
  private float partido;
  @Column(name="helado")
  private float helado;
  @Column(name="chuzo")
  private float chuzo;
  @Column(name="marron")
  private float marron;
  @Column(name="roido")
  private float roido;
  @Column(name="p_de_c")
  private float pDeC; //picado de campo
  @Column(name="contrastante")
  private float contrastante;
  @Column(name="leve_A")
  private float leveA;
  @Column(name="leve_B")
  private float leveB;
  @Column(name="descorticado")
  private float descorticado;
  @Column(name="cascado")
  private float cascado;
  @Column(name="arrugado")
  private float arrugado;
  @Column(name="revolcado")
  private float revolcado;
  @Column(name="manchado_maquina")
  private float manchadoMaquina;
  @Column(name="punta_chaucha")
  private float puntaChaucha;
  @Column(name="pinto")
  private float pinto;
  @Column(name="bolita")
  private float bolita;
  @Column(name="oxidado")
  private float oxidado;
  @Column(name="quebrado")
  private float quebrado;
  @Column(name="brotado")
  private float brotado;
  @Column(name="venoso")
  private float venoso;
  @Column(name="decolorido")
  private float decolorido;
  @Column(name="humedad")
  private float humedad;
  @Column(name="gramaje")
  private float gramaje;
  @Column(name="hidratacion")
  private float hidratacion;
  @Column(name="fecha_realizacion")
  private Date analysisDate;
  @JsonIgnore
  @Column(name="fecha_modificacion")
  private Date modificationDate;
  
  public Analysis () {
  }

  public Analysis(Long id, float zaranda, float caidaZaranda, float incomestible, float terron,
      float manchado, float partido, float helado, float chuzo, float marron, float roido,
      float pDeC, float contrastante, float leveA, float leveB, float descorticado, float cascado,
      float arrugado, float revolcado, float manchadoMaquina, float puntaChaucha, float pinto,
      float bolita, float oxidado, float quebrado, float brotado, float venoso, float decolorido,
      float humedad, float gramaje, float hidratacion, Date analysisDate,
      Date modificationDate) {
    this.id = id;
    this.zaranda = zaranda;
    this.caidaZaranda = caidaZaranda;
    this.incomestible = incomestible;
    this.terron = terron;
    this.manchado = manchado;
    this.partido = partido;
    this.helado = helado;
    this.chuzo = chuzo;
    this.marron = marron;
    this.roido = roido;
    this.pDeC = pDeC;
    this.contrastante = contrastante;
    this.leveA = leveA;
    this.leveB = leveB;
    this.descorticado = descorticado;
    this.cascado = cascado;
    this.arrugado = arrugado;
    this.revolcado = revolcado;
    this.manchadoMaquina = manchadoMaquina;
    this.puntaChaucha = puntaChaucha;
    this.pinto = pinto;
    this.bolita = bolita;
    this.oxidado = oxidado;
    this.quebrado = quebrado;
    this.brotado = brotado;
    this.venoso = venoso;
    this.decolorido = decolorido;
    this.humedad = humedad;
    this.gramaje = gramaje;
    this.hidratacion = hidratacion;
    this.analysisDate = analysisDate;
    this.modificationDate = modificationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public float getZaranda() {
    return zaranda;
  }

  public void setZaranda(float zaranda) {
    this.zaranda = zaranda;
  }

  public float getCaidaZaranda() {
    return caidaZaranda;
  }

  public void setCaidaZaranda(float caidaZaranda) {
    this.caidaZaranda = caidaZaranda;
  }

  public float getIncomestible() {
    return incomestible;
  }

  public void setIncomestible(float incomestible) {
    this.incomestible = incomestible;
  }

  public float getTerron() {
    return terron;
  }

  public void setTerron(float terron) {
    this.terron = terron;
  }

  public float getManchado() {
    return manchado;
  }

  public void setManchado(float manchado) {
    this.manchado = manchado;
  }

  public float getPartido() {
    return partido;
  }

  public void setPartido(float partido) {
    this.partido = partido;
  }

  public float getHelado() {
    return helado;
  }

  public void setHelado(float helado) {
    this.helado = helado;
  }

  public float getChuzo() {
    return chuzo;
  }

  public void setChuzo(float chuzo) {
    this.chuzo = chuzo;
  }

  public float getMarron() {
    return marron;
  }

  public void setMarron(float marron) {
    this.marron = marron;
  }

  public float getRoido() {
    return roido;
  }

  public void setRoido(float roido) {
    this.roido = roido;
  }

  public float getpDeC() {
    return pDeC;
  }

  public void setpDeC(float pDeC) {
    this.pDeC = pDeC;
  }

  public float getContrastante() {
    return contrastante;
  }

  public void setContrastante(float contrastante) {
    this.contrastante = contrastante;
  }

  public float getLeveA() {
    return leveA;
  }

  public void setLeveA(float leveA) {
    this.leveA = leveA;
  }

  public float getLeveB() {
    return leveB;
  }

  public void setLeveB(float leveB) {
    this.leveB = leveB;
  }

  public float getDescorticado() {
    return descorticado;
  }

  public void setDescorticado(float descorticado) {
    this.descorticado = descorticado;
  }

  public float getCascado() {
    return cascado;
  }

  public void setCascado(float cascado) {
    this.cascado = cascado;
  }

  public float getArrugado() {
    return arrugado;
  }

  public void setArrugado(float arrugado) {
    this.arrugado = arrugado;
  }

  public float getRevolcado() {
    return revolcado;
  }

  public void setRevolcado(float revolcado) {
    this.revolcado = revolcado;
  }

  public float getManchadoMaquina() {
    return manchadoMaquina;
  }

  public void setManchadoMaquina(float manchadoMaquina) {
    this.manchadoMaquina = manchadoMaquina;
  }

  public float getPuntaChaucha() {
    return puntaChaucha;
  }

  public void setPuntaChaucha(float puntaChaucha) {
    this.puntaChaucha = puntaChaucha;
  }

  public float getPinto() {
    return pinto;
  }

  public void setPinto(float pinto) {
    this.pinto = pinto;
  }

  public float getBolita() {
    return bolita;
  }

  public void setBolita(float bolita) {
    this.bolita = bolita;
  }

  public float getOxidado() {
    return oxidado;
  }

  public void setOxidado(float oxidado) {
    this.oxidado = oxidado;
  }

  public float getQuebrado() {
    return quebrado;
  }

  public void setQuebrado(float quebrado) {
    this.quebrado = quebrado;
  }

  public float getBrotado() {
    return brotado;
  }

  public void setBrotado(float brotado) {
    this.brotado = brotado;
  }

  public float getVenoso() {
    return venoso;
  }

  public void setVenoso(float venoso) {
    this.venoso = venoso;
  }

  public float getDecolorido() {
    return decolorido;
  }

  public void setDecolorido(float decolorido) {
    this.decolorido = decolorido;
  }

  public float getHumedad() {
    return humedad;
  }

  public void setHumedad(float humedad) {
    this.humedad = humedad;
  }

  public float getGramaje() {
    return gramaje;
  }

  public void setGramaje(float gramaje) {
    this.gramaje = gramaje;
  }

  public float getHidratacion() {
    return hidratacion;
  }

  public void setHidratacion(float hidratacion) {
    this.hidratacion = hidratacion;
  }

  public Date getAnalysisDate() {
    return analysisDate;
  }

  public void setAnalysisDate(Date analysisDate) {
    this.analysisDate = analysisDate;
  }

  public Date getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }
}

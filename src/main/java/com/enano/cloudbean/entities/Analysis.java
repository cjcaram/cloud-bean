package com.enano.cloudbean.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "analisis")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Analysis {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="zaranda")
  private Float zaranda;
  @Column(name="caida_zaranda")
  private Float caidaZaranda;
  @Column(name="incomestible")
  private Float incomestible;
  @Column(name="terron")
  private Float terron;
  @Column(name="manchado")
  private Float manchado;
  @Column(name="partido")
  private Float partido;
  @Column(name="helado")
  private Float helado;
  @Column(name="chuzo")
  private Float chuzo;
  @Column(name="tiempo_de_coccion")
  private Float tiempoCoccion;
  @Column(name="roido")
  private Float roido;
  @Column(name="picado_de_campo")
  private Float picadoCampo;
  @Column(name="contrastante")
  private Float contrastante;
  @Column(name="leve_A")
  private Float leveA;
  @Column(name="leve_B")
  private Float leveB;
  @Column(name="descorticado")
  private Float descorticado;
  @Column(name="cascado")
  private Float cascado;
  @Column(name="arrugado")
  private Float arrugado;
  @Column(name="revolcado")
  private Float revolcado;
  @Column(name="manchado_maquina")
  private Float manchadoMaquina;
  @Column(name="punta_chaucha")
  private Float puntaChaucha;
  @Column(name="pinto")
  private Float pinto;
  @Column(name="bolita")
  private Float bolita;
  @Column(name="oxidado")
  private Float oxidado;
  @Column(name="quebrado")
  private Float quebrado;
  @Column(name="brotado")
  private Float brotado;
  @Column(name="venoso")
  private Float venoso;
  @Column(name="decolorido")
  private Float decolorido;
  @Column(name="humedad")
  private Float humedad;
  @Column(name="gramaje")
  private Float gramaje;
  @Column(name="hidratacion")
  private Float hidratacion;
  @Column(name="fecha_realizacion")
  private Date analysisDate;
  @JsonIgnore
  @Column(name="fecha_modificacion")
  private Date modificationDate;
  
  public Analysis () {
  }

  public Analysis(Long id, Float zaranda, Float caidaZaranda, Float incomestible, Float terron,
      Float manchado, Float partido, Float helado, Float chuzo, Float tiempoCoccion, Float roido,
      Float picadoCampo, Float contrastante, Float leveA, Float leveB, Float descorticado, Float cascado,
      Float arrugado, Float revolcado, Float manchadoMaquina, Float puntaChaucha, Float pinto,
      Float bolita, Float oxidado, Float quebrado, Float brotado, Float venoso, Float decolorido,
      Float humedad, Float gramaje, Float hidratacion, Date analysisDate,
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
    this.tiempoCoccion = tiempoCoccion;
    this.roido = roido;
    this.picadoCampo = picadoCampo;
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

  public Float getZaranda() {
    return zaranda;
  }

  public void setZaranda(Float zaranda) {
    this.zaranda = zaranda;
  }

  public Float getCaidaZaranda() {
    return caidaZaranda;
  }

  public void setCaidaZaranda(Float caidaZaranda) {
    this.caidaZaranda = caidaZaranda;
  }

  public Float getIncomestible() {
    return incomestible;
  }

  public void setIncomestible(Float incomestible) {
    this.incomestible = incomestible;
  }

  public Float getTerron() {
    return terron;
  }

  public void setTerron(Float terron) {
    this.terron = terron;
  }

  public Float getManchado() {
    return manchado;
  }

  public void setManchado(Float manchado) {
    this.manchado = manchado;
  }

  public Float getPartido() {
    return partido;
  }

  public void setPartido(Float partido) {
    this.partido = partido;
  }

  public Float getHelado() {
    return helado;
  }

  public void setHelado(Float helado) {
    this.helado = helado;
  }

  public Float getChuzo() {
    return chuzo;
  }

  public void setChuzo(Float chuzo) {
    this.chuzo = chuzo;
  }

  public Float getTiempoCoccion() {
    return tiempoCoccion;
  }

  public void setTiempoCoccion(Float tiempoCoccion) {
    this.tiempoCoccion = tiempoCoccion;
  }

  public Float getRoido() {
    return roido;
  }

  public void setRoido(Float roido) {
    this.roido = roido;
  }

  public Float getPicadoCampo() {
    return picadoCampo;
  }

  public void setPicadoCampo(Float picadoCampo) {
    this.picadoCampo = picadoCampo;
  }

  public Float getContrastante() {
    return contrastante;
  }

  public void setContrastante(Float contrastante) {
    this.contrastante = contrastante;
  }

  public Float getLeveA() {
    return leveA;
  }

  public void setLeveA(Float leveA) {
    this.leveA = leveA;
  }

  public Float getLeveB() {
    return leveB;
  }

  public void setLeveB(Float leveB) {
    this.leveB = leveB;
  }

  public Float getDescorticado() {
    return descorticado;
  }

  public void setDescorticado(Float descorticado) {
    this.descorticado = descorticado;
  }

  public Float getCascado() {
    return cascado;
  }

  public void setCascado(Float cascado) {
    this.cascado = cascado;
  }

  public Float getArrugado() {
    return arrugado;
  }

  public void setArrugado(Float arrugado) {
    this.arrugado = arrugado;
  }

  public Float getRevolcado() {
    return revolcado;
  }

  public void setRevolcado(Float revolcado) {
    this.revolcado = revolcado;
  }

  public Float getManchadoMaquina() {
    return manchadoMaquina;
  }

  public void setManchadoMaquina(Float manchadoMaquina) {
    this.manchadoMaquina = manchadoMaquina;
  }

  public Float getPuntaChaucha() {
    return puntaChaucha;
  }

  public void setPuntaChaucha(Float puntaChaucha) {
    this.puntaChaucha = puntaChaucha;
  }

  public Float getPinto() {
    return pinto;
  }

  public void setPinto(Float pinto) {
    this.pinto = pinto;
  }

  public Float getBolita() {
    return bolita;
  }

  public void setBolita(Float bolita) {
    this.bolita = bolita;
  }

  public Float getOxidado() {
    return oxidado;
  }

  public void setOxidado(Float oxidado) {
    this.oxidado = oxidado;
  }

  public Float getQuebrado() {
    return quebrado;
  }

  public void setQuebrado(Float quebrado) {
    this.quebrado = quebrado;
  }

  public Float getBrotado() {
    return brotado;
  }

  public void setBrotado(Float brotado) {
    this.brotado = brotado;
  }

  public Float getVenoso() {
    return venoso;
  }

  public void setVenoso(Float venoso) {
    this.venoso = venoso;
  }

  public Float getDecolorido() {
    return decolorido;
  }

  public void setDecolorido(Float decolorido) {
    this.decolorido = decolorido;
  }

  public Float getHumedad() {
    return humedad;
  }

  public void setHumedad(Float humedad) {
    this.humedad = humedad;
  }

  public Float getGramaje() {
    return gramaje;
  }

  public void setGramaje(Float gramaje) {
    this.gramaje = gramaje;
  }

  public Float getHidratacion() {
    return hidratacion;
  }

  public void setHidratacion(Float hidratacion) {
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

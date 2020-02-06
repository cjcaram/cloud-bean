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
@Table(name = "analisis")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Analysis {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "zaranda")
  private Float zaranda;
  @Column(name = "caida_zaranda")
  private Float caidaZaranda;
  @Column(name = "incomestible")
  private Float incomestible;
  @Column(name = "terron")
  private Float terron;
  @Column(name = "manchado")
  private Float manchado;
  @Column(name = "partido")
  private Float partido;
  @Column(name = "helado")
  private Float helado;
  @Column(name = "chuzo")
  private Float chuzo;
  @Column(name = "tiempo_de_coccion")
  private Float tiempoCoccion;
  @Column(name = "roido")
  private Float roido;
  @Column(name = "picado_de_campo")
  private Float picadoCampo;
  @Column(name = "contrastante")
  private Float contrastante;
  @Column(name = "leve_A")
  private Float leveA;
  @Column(name = "leve_B")
  private Float leveB;
  @Column(name = "descorticado")
  private Float descorticado;
  @Column(name = "cascado")
  private Float cascado;
  @Column(name = "arrugado")
  private Float arrugado;
  @Column(name = "revolcado")
  private Float revolcado;
  @Column(name = "manchado_maquina")
  private Float manchadoMaquina;
  @Column(name = "punta_chaucha")
  private Float puntaChaucha;
  @Column(name = "pinto")
  private Float pinto;
  @Column(name = "bolita")
  private Float bolita;
  @Column(name = "oxidado")
  private Float oxidado;
  @Column(name = "quebrado")
  private Float quebrado;
  @Column(name = "brotado")
  private Float brotado;
  @Column(name = "venoso")
  private Float venoso;
  @Column(name = "decolorido")
  private Float decolorido;
  @Column(name = "humedad")
  private Float humedad;
  @Column(name = "gramaje")
  private Integer gramaje;
  @Column(name = "hidratacion")
  private Float hidratacion;
  @Column(name = "fecha_realizacion")
  private Date analysisDate;
  @JsonIgnore
  @Column(name = "fecha_modificacion")
  private Date modificationDate;

  public Analysis() {}

  public Analysis(Long id, Float zaranda, Float caidaZaranda, Float incomestible, Float terron,
      Float manchado, Float partido, Float helado, Float chuzo, Float tiempoCoccion, Float roido,
      Float picadoCampo, Float contrastante, Float leveA, Float leveB, Float descorticado,
      Float cascado, Float arrugado, Float revolcado, Float manchadoMaquina, Float puntaChaucha,
      Float pinto, Float bolita, Float oxidado, Float quebrado, Float brotado, Float venoso,
      Float decolorido, Float humedad, Integer gramaje, Float hidratacion, Date analysisDate,
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
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = (id != null && id < 0) ? null : id;
  }

  public Float getZaranda() {
    return (zaranda != null) ? zaranda : 0F;
  }

  public void setZaranda(Float zaranda) {
    this.zaranda = zaranda;
  }

  public Float getCaidaZaranda() {
    return (caidaZaranda != null) ? caidaZaranda : 0F;
  }

  public void setCaidaZaranda(Float caidaZaranda) {
    this.caidaZaranda = caidaZaranda;
  }

  public Float getIncomestible() {
    return (incomestible != null) ? incomestible : 0F;
  }

  public void setIncomestible(Float incomestible) {
    this.incomestible = incomestible;
  }

  public Float getTerron() {
    return (terron != null) ? terron : 0F;
  }

  public void setTerron(Float terron) {
    this.terron = terron;
  }

  public Float getManchado() {
    return (manchado != null) ? manchado : 0F;
  }

  public void setManchado(Float manchado) {
    this.manchado = manchado;
  }

  public Float getPartido() {
    return (partido != null) ? partido : 0F;
  }

  public void setPartido(Float partido) {
    this.partido = partido;
  }

  public Float getHelado() {
    return (helado != null) ? helado : 0F;
  }

  public void setHelado(Float helado) {
    this.helado = helado;
  }

  public Float getChuzo() {
    return (chuzo != null) ? chuzo : 0F;
  }

  public void setChuzo(Float chuzo) {
    this.chuzo = chuzo;
  }

  public Float getTiempoCoccion() {
    return (tiempoCoccion != null) ? tiempoCoccion : 0F;
  }

  public void setTiempoCoccion(Float tiempoCoccion) {
    this.tiempoCoccion = tiempoCoccion;
  }

  public Float getRoido() {
    return (roido != null) ? roido : 0F;
  }

  public void setRoido(Float roido) {
    this.roido = roido;
  }

  public Float getPicadoCampo() {
    return (picadoCampo != null) ? picadoCampo : 0F;
  }

  public void setPicadoCampo(Float picadoCampo) {
    this.picadoCampo = picadoCampo;
  }

  public Float getContrastante() {
    return (contrastante != null) ? contrastante : 0F;
  }

  public void setContrastante(Float contrastante) {
    this.contrastante = contrastante;
  }

  public Float getLeveA() {
    return (leveA != null) ? leveA : 0F;
  }

  public void setLeveA(Float leveA) {
    this.leveA = leveA;
  }

  public Float getLeveB() {
    return (leveB != null) ? leveB : 0F;
  }

  public void setLeveB(Float leveB) {
    this.leveB = leveB;
  }

  public Float getDescorticado() {
    return (descorticado != null) ? descorticado : 0F;
  }

  public void setDescorticado(Float descorticado) {
    this.descorticado = descorticado;
  }

  public Float getCascado() {
    return (cascado != null) ? cascado : 0F;
  }

  public void setCascado(Float cascado) {
    this.cascado = cascado;
  }

  public Float getArrugado() {
    return (arrugado != null) ? arrugado : 0F;
  }

  public void setArrugado(Float arrugado) {
    this.arrugado = arrugado;
  }

  public Float getRevolcado() {
    return (revolcado != null) ? revolcado : 0F;
  }

  public void setRevolcado(Float revolcado) {
    this.revolcado = revolcado;
  }

  public Float getManchadoMaquina() {
    return (manchadoMaquina != null) ? manchadoMaquina : 0F;
  }

  public void setManchadoMaquina(Float manchadoMaquina) {
    this.manchadoMaquina = manchadoMaquina;
  }

  public Float getPuntaChaucha() {
    return (puntaChaucha != null) ? puntaChaucha : 0F;
  }

  public void setPuntaChaucha(Float puntaChaucha) {
    this.puntaChaucha = puntaChaucha;
  }

  public Float getPinto() {
    return (pinto != null) ? pinto : 0F;
  }

  public void setPinto(Float pinto) {
    this.pinto = pinto;
  }

  public Float getBolita() {
    return (bolita != null) ? bolita : 0F;
  }

  public void setBolita(Float bolita) {
    this.bolita = bolita;
  }

  public Float getOxidado() {
    return (oxidado != null) ? oxidado : 0F;
  }

  public void setOxidado(Float oxidado) {
    this.oxidado = oxidado;
  }

  public Float getQuebrado() {
    return (quebrado != null) ? quebrado : 0F;
  }

  public void setQuebrado(Float quebrado) {
    this.quebrado = quebrado;
  }

  public Float getBrotado() {
    return (brotado != null) ? brotado : 0F;
  }

  public void setBrotado(Float brotado) {
    this.brotado = brotado;
  }

  public Float getVenoso() {
    return (venoso != null) ? venoso : 0F;
  }

  public void setVenoso(Float venoso) {
    this.venoso = venoso;
  }

  public Float getDecolorido() {
    return (decolorido != null) ? decolorido : 0F;
  }

  public void setDecolorido(Float decolorido) {
    this.decolorido = decolorido;
  }

  public Float getHumedad() {
    return (humedad != null) ? humedad : 0F;
  }

  public void setHumedad(Float humedad) {
    this.humedad = humedad;
  }

  public Integer getGramaje() {
    return (gramaje != null) ? gramaje : -1;
  }

  public void setGramaje(Integer gramaje) {
    this.gramaje = gramaje;
  }

  public Float getHidratacion() {
    return (hidratacion != null) ? hidratacion : 0F;
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

  public void setModificationDate() {
    this.modificationDate = new Date();
  }

  public Float getCaida() {
    return (getIncomestible() + getTerron() + getCaidaZaranda() + getManchado() + getPartido()
        + getHelado() + getChuzo() + getRoido() + getPicadoCampo() + getContrastante()
        + getDescorticado() + getQuebrado() + getBrotado() + getRevolcado() + getLeveA());
  }

  @Override
  public String toString() {
    return "Analysis [id=" + id + ", zaranda=" + zaranda + ", caidaZaranda=" + caidaZaranda
        + ", incomestible=" + incomestible + ", terron=" + terron + ", manchado=" + manchado
        + ", partido=" + partido + ", helado=" + helado + ", chuzo=" + chuzo + ", tiempoCoccion="
        + tiempoCoccion + ", roido=" + roido + ", picadoCampo=" + picadoCampo + ", contrastante="
        + contrastante + ", leveA=" + leveA + ", leveB=" + leveB + ", descorticado=" + descorticado
        + ", cascado=" + cascado + ", arrugado=" + arrugado + ", revolcado=" + revolcado
        + ", manchadoMaquina=" + manchadoMaquina + ", puntaChaucha=" + puntaChaucha + ", pinto="
        + pinto + ", bolita=" + bolita + ", oxidado=" + oxidado + ", quebrado=" + quebrado
        + ", brotado=" + brotado + ", venoso=" + venoso + ", decolorido=" + decolorido
        + ", humedad=" + humedad + ", gramaje=" + gramaje + ", hidratacion=" + hidratacion
        + ", analysisDate=" + analysisDate + ", modificationDate=" + modificationDate + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((analysisDate == null) ? 0 : analysisDate.hashCode());
    result = prime * result + ((arrugado == null) ? 0 : arrugado.hashCode());
    result = prime * result + ((bolita == null) ? 0 : bolita.hashCode());
    result = prime * result + ((brotado == null) ? 0 : brotado.hashCode());
    result = prime * result + ((caidaZaranda == null) ? 0 : caidaZaranda.hashCode());
    result = prime * result + ((cascado == null) ? 0 : cascado.hashCode());
    result = prime * result + ((chuzo == null) ? 0 : chuzo.hashCode());
    result = prime * result + ((contrastante == null) ? 0 : contrastante.hashCode());
    result = prime * result + ((decolorido == null) ? 0 : decolorido.hashCode());
    result = prime * result + ((descorticado == null) ? 0 : descorticado.hashCode());
    result = prime * result + ((gramaje == null) ? 0 : gramaje.hashCode());
    result = prime * result + ((helado == null) ? 0 : helado.hashCode());
    result = prime * result + ((hidratacion == null) ? 0 : hidratacion.hashCode());
    result = prime * result + ((humedad == null) ? 0 : humedad.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((incomestible == null) ? 0 : incomestible.hashCode());
    result = prime * result + ((leveA == null) ? 0 : leveA.hashCode());
    result = prime * result + ((leveB == null) ? 0 : leveB.hashCode());
    result = prime * result + ((manchado == null) ? 0 : manchado.hashCode());
    result = prime * result + ((manchadoMaquina == null) ? 0 : manchadoMaquina.hashCode());
    result = prime * result + ((modificationDate == null) ? 0 : modificationDate.hashCode());
    result = prime * result + ((oxidado == null) ? 0 : oxidado.hashCode());
    result = prime * result + ((partido == null) ? 0 : partido.hashCode());
    result = prime * result + ((picadoCampo == null) ? 0 : picadoCampo.hashCode());
    result = prime * result + ((pinto == null) ? 0 : pinto.hashCode());
    result = prime * result + ((puntaChaucha == null) ? 0 : puntaChaucha.hashCode());
    result = prime * result + ((quebrado == null) ? 0 : quebrado.hashCode());
    result = prime * result + ((revolcado == null) ? 0 : revolcado.hashCode());
    result = prime * result + ((roido == null) ? 0 : roido.hashCode());
    result = prime * result + ((terron == null) ? 0 : terron.hashCode());
    result = prime * result + ((tiempoCoccion == null) ? 0 : tiempoCoccion.hashCode());
    result = prime * result + ((venoso == null) ? 0 : venoso.hashCode());
    result = prime * result + ((zaranda == null) ? 0 : zaranda.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Analysis other = (Analysis) obj;
    if (analysisDate == null) {
      if (other.analysisDate != null)
        return false;
    } else if (!analysisDate.equals(other.analysisDate))
      return false;
    if (arrugado == null) {
      if (other.arrugado != null)
        return false;
    } else if (!arrugado.equals(other.arrugado))
      return false;
    if (bolita == null) {
      if (other.bolita != null)
        return false;
    } else if (!bolita.equals(other.bolita))
      return false;
    if (brotado == null) {
      if (other.brotado != null)
        return false;
    } else if (!brotado.equals(other.brotado))
      return false;
    if (caidaZaranda == null) {
      if (other.caidaZaranda != null)
        return false;
    } else if (!caidaZaranda.equals(other.caidaZaranda))
      return false;
    if (cascado == null) {
      if (other.cascado != null)
        return false;
    } else if (!cascado.equals(other.cascado))
      return false;
    if (chuzo == null) {
      if (other.chuzo != null)
        return false;
    } else if (!chuzo.equals(other.chuzo))
      return false;
    if (contrastante == null) {
      if (other.contrastante != null)
        return false;
    } else if (!contrastante.equals(other.contrastante))
      return false;
    if (decolorido == null) {
      if (other.decolorido != null)
        return false;
    } else if (!decolorido.equals(other.decolorido))
      return false;
    if (descorticado == null) {
      if (other.descorticado != null)
        return false;
    } else if (!descorticado.equals(other.descorticado))
      return false;
    if (gramaje == null) {
      if (other.gramaje != null)
        return false;
    } else if (!gramaje.equals(other.gramaje))
      return false;
    if (helado == null) {
      if (other.helado != null)
        return false;
    } else if (!helado.equals(other.helado))
      return false;
    if (hidratacion == null) {
      if (other.hidratacion != null)
        return false;
    } else if (!hidratacion.equals(other.hidratacion))
      return false;
    if (humedad == null) {
      if (other.humedad != null)
        return false;
    } else if (!humedad.equals(other.humedad))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (incomestible == null) {
      if (other.incomestible != null)
        return false;
    } else if (!incomestible.equals(other.incomestible))
      return false;
    if (leveA == null) {
      if (other.leveA != null)
        return false;
    } else if (!leveA.equals(other.leveA))
      return false;
    if (leveB == null) {
      if (other.leveB != null)
        return false;
    } else if (!leveB.equals(other.leveB))
      return false;
    if (manchado == null) {
      if (other.manchado != null)
        return false;
    } else if (!manchado.equals(other.manchado))
      return false;
    if (manchadoMaquina == null) {
      if (other.manchadoMaquina != null)
        return false;
    } else if (!manchadoMaquina.equals(other.manchadoMaquina))
      return false;
    if (modificationDate == null) {
      if (other.modificationDate != null)
        return false;
    } else if (!modificationDate.equals(other.modificationDate))
      return false;
    if (oxidado == null) {
      if (other.oxidado != null)
        return false;
    } else if (!oxidado.equals(other.oxidado))
      return false;
    if (partido == null) {
      if (other.partido != null)
        return false;
    } else if (!partido.equals(other.partido))
      return false;
    if (picadoCampo == null) {
      if (other.picadoCampo != null)
        return false;
    } else if (!picadoCampo.equals(other.picadoCampo))
      return false;
    if (pinto == null) {
      if (other.pinto != null)
        return false;
    } else if (!pinto.equals(other.pinto))
      return false;
    if (puntaChaucha == null) {
      if (other.puntaChaucha != null)
        return false;
    } else if (!puntaChaucha.equals(other.puntaChaucha))
      return false;
    if (quebrado == null) {
      if (other.quebrado != null)
        return false;
    } else if (!quebrado.equals(other.quebrado))
      return false;
    if (revolcado == null) {
      if (other.revolcado != null)
        return false;
    } else if (!revolcado.equals(other.revolcado))
      return false;
    if (roido == null) {
      if (other.roido != null)
        return false;
    } else if (!roido.equals(other.roido))
      return false;
    if (terron == null) {
      if (other.terron != null)
        return false;
    } else if (!terron.equals(other.terron))
      return false;
    if (tiempoCoccion == null) {
      if (other.tiempoCoccion != null)
        return false;
    } else if (!tiempoCoccion.equals(other.tiempoCoccion))
      return false;
    if (venoso == null) {
      if (other.venoso != null)
        return false;
    } else if (!venoso.equals(other.venoso))
      return false;
    if (zaranda == null) {
      if (other.zaranda != null)
        return false;
    } else if (!zaranda.equals(other.zaranda))
      return false;
    return true;
  }
}

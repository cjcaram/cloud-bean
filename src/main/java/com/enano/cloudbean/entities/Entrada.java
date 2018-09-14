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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "entrada")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Entrada {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "analisis_id")
  private Integer analisisId;
  @Column(name = "numero_ingreso")
  private int nroIngreso;
  @Column(name = "carta_de_porte")
  private String cartaDePorte;
  @Column(name = "cert_de_deposito")
  private String certDeDeposito;
  @Column(name = "CTG")
  private String ctg;
  @Column(name = "peso_bruto")
  private int pesoBruto;
  @Column(name = "peso_tara")
  private int pesoTara;
  @Column(name = "chofer")
  private String chofer;
  @Column(name = "patente_camion")
  private String patenteCamion;
  @Column(name = "patente_acoplado")
  private String patenteAcoplado;
  @Column(name = "titular_CP")
  private Integer titularCartaPorteId;
  @Column(name = "remitente_comercial")
  private Integer remitenteComercialId;
  @Column(name = "destinatario")
  private Integer destinatarioId;
  @Column(name = "transporte")
  private Integer tranporteId;
  @Column(name = "procedencia")
  private Integer procedenciaId;
  @ManyToOne
  @JoinColumn(name = "grano_especie_id")
  private GranoEspecie granoEspecie;
  @Column(name = "cantidad_bolsa")
  private int cantidadBolsa;
  @ManyToOne
  @JoinColumn(name = "tipo_bolsa")
  private EmpaqueTipo empaqueTipo;
  @Column(name = "ubicacion")
  private String ubicacion;
  @Column(name = "fecha_descarga")
  private Date fechaDescarga;
  @Column(name = "fecha_modificacion")
  private Date fechaModificacion;
  @Column(name = "observaciones")
  private String obs;
  @Column(name = "img_dir")
  private String imgDir;
  
  public Entrada() {
    
  }

  public Entrada(Long id, Integer analisisId, int nroIngreso, String cartaDePorte,
      String certDeDeposito, String ctg, int pesoBruto, int pesoTara, String chofer,
      String patenteCamion, String patenteAcoplado, Integer titularCartaPorteId,
      Integer remitenteComercialId, Integer destinatarioId, Integer tranporteId,
      Integer procedenciaId, GranoEspecie granoEspecie, int cantidadBolsa, EmpaqueTipo empaqueTipo,
      String ubicacion, Date fechaDescarga, Date fechaModificacion, String obs, String imgDir) {
    this.id = id;
    this.analisisId = analisisId;
    this.nroIngreso = nroIngreso;
    this.cartaDePorte = cartaDePorte;
    this.certDeDeposito = certDeDeposito;
    this.ctg = ctg;
    this.pesoBruto = pesoBruto;
    this.pesoTara = pesoTara;
    this.chofer = chofer;
    this.patenteCamion = patenteCamion;
    this.patenteAcoplado = patenteAcoplado;
    this.titularCartaPorteId = titularCartaPorteId;
    this.remitenteComercialId = remitenteComercialId;
    this.destinatarioId = destinatarioId;
    this.tranporteId = tranporteId;
    this.procedenciaId = procedenciaId;
    this.granoEspecie = granoEspecie;
    this.cantidadBolsa = cantidadBolsa;
    this.empaqueTipo = empaqueTipo;
    this.ubicacion = ubicacion;
    this.fechaDescarga = fechaDescarga;
    this.fechaModificacion = fechaModificacion;
    this.obs = obs;
    this.imgDir = imgDir;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getAnalisisId() {
    return analisisId;
  }

  public void setAnalisisId(Integer analisisId) {
    this.analisisId = analisisId;
  }

  public int getNroIngreso() {
    return nroIngreso;
  }

  public void setNroIngreso(int nroIngreso) {
    this.nroIngreso = nroIngreso;
  }

  public String getCartaDePorte() {
    return cartaDePorte;
  }

  public void setCartaDePorte(String cartaDePorte) {
    this.cartaDePorte = cartaDePorte;
  }

  public String getCertDeDeposito() {
    return certDeDeposito;
  }

  public void setCertDeDeposito(String certDeDeposito) {
    this.certDeDeposito = certDeDeposito;
  }

  public String getCtg() {
    return ctg;
  }

  public void setCtg(String ctg) {
    this.ctg = ctg;
  }

  public int getPesoBruto() {
    return pesoBruto;
  }

  public void setPesoBruto(int pesoBruto) {
    this.pesoBruto = pesoBruto;
  }

  public int getPesoTara() {
    return pesoTara;
  }

  public void setPesoTara(int pesoTara) {
    this.pesoTara = pesoTara;
  }

  public String getChofer() {
    return chofer;
  }

  public void setChofer(String chofer) {
    this.chofer = chofer;
  }

  public String getPatenteCamion() {
    return patenteCamion;
  }

  public void setPatenteCamion(String patenteCamion) {
    this.patenteCamion = patenteCamion;
  }

  public String getPatenteAcoplado() {
    return patenteAcoplado;
  }

  public void setPatenteAcoplado(String patenteAcoplado) {
    this.patenteAcoplado = patenteAcoplado;
  }

  public Integer getTitularCartaPorteId() {
    return titularCartaPorteId;
  }

  public void setTitularCartaPorteId(Integer titularCartaPorteId) {
    this.titularCartaPorteId = titularCartaPorteId;
  }

  public Integer getRemitenteComercialId() {
    return remitenteComercialId;
  }

  public void setRemitenteComercialId(Integer remitenteComercialId) {
    this.remitenteComercialId = remitenteComercialId;
  }

  public Integer getDestinatarioId() {
    return destinatarioId;
  }

  public void setDestinatarioId(Integer destinatarioId) {
    this.destinatarioId = destinatarioId;
  }

  public Integer getTranporteId() {
    return tranporteId;
  }

  public void setTranporteId(Integer tranporteId) {
    this.tranporteId = tranporteId;
  }

  public Integer getProcedenciaId() {
    return procedenciaId;
  }

  public void setProcedenciaId(Integer procedenciaId) {
    this.procedenciaId = procedenciaId;
  }

  public GranoEspecie getGranoEspecie() {
    return granoEspecie;
  }

  public void setGranoEspecie(GranoEspecie granoEspecie) {
    this.granoEspecie = granoEspecie;
  }

  public int getCantidadBolsa() {
    return cantidadBolsa;
  }

  public void setCantidadBolsa(int cantidadBolsa) {
    this.cantidadBolsa = cantidadBolsa;
  }

  public EmpaqueTipo getEmpaqueTipo() {
    return empaqueTipo;
  }

  public void setEmpaqueTipo(EmpaqueTipo empaqueTipo) {
    this.empaqueTipo = empaqueTipo;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public Date getFechaDescarga() {
    return fechaDescarga;
  }

  public void setFechaDescarga(Date fechaDescarga) {
    this.fechaDescarga = fechaDescarga;
  }

  public Date getFechaModificacion() {
    return fechaModificacion;
  }

  public void setFechaModificacion(Date fechaModificacion) {
    this.fechaModificacion = fechaModificacion;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public String getImgDir() {
    return imgDir;
  }

  public void setImgDir(String imgDir) {
    this.imgDir = imgDir;
  }
  
}


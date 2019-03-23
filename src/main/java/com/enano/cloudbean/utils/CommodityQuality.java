package com.enano.cloudbean.utils;

public enum CommodityQuality {
  EXPORTACION("EXPORTACION"), 
  NATURAL("NATURAL"),
  SEMILLA("SEMILLA"),
  DESCARTE("DESCARTE"), 
  PADRON("PADRON"), 
  SEGUNDILLA("SEGUNDILLA"), 
  RECUPERO_ELEC_1("RECUPERO ELECTRONICA 1"), 
  RECUPERO_ELEC_2("RECUPERO ELECTRONICA 2"), 
  RECUPERO_VIBRA("RECUPERO VIBRADORA"), 
  TIERRA("TIERRA"), 
  VOLATIL("VOLATIL"), 
  PAJA("PAJA"), 
  BASURA("BASURA"), 
  DESCARTE_TARARA("DESCARTE TARARA");
    
  private String type;
  
  private CommodityQuality (String type){
    this.type = type;
  }

  public String getType() {
    return type;
  }

}

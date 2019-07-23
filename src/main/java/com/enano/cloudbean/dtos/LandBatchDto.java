package com.enano.cloudbean.dtos;

public class LandBatchDto {
  private Long id;
  private Long parentId;
  private String parentName;
  private String name;
  private int haAmount;
  private String note;
  
  public LandBatchDto() {
    
  }
  
  public LandBatchDto(Long id, Long parentId, String parentName, String name, int haAmount,
      String note) {
    this.id = id;
    this.parentId = parentId;
    this.parentName = parentName;
    this.name = name;
    this.haAmount = haAmount;
    this.note = note;
  }
  
  public LandBatchDto(Long id, String name, int haAmount,
      String note) {
    this.id = id;
    this.name = name;
    this.haAmount = haAmount;
    this.note = note;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getParentId() {
    return parentId;
  }

  public void setParentId(Long parentId) {
    this.parentId = parentId;
  }

  public String getParentName() {
    return parentName;
  }

  public void setParentName(String parentName) {
    this.parentName = parentName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHaAmount() {
    return haAmount;
  }

  public void setHaAmount(int haAmount) {
    this.haAmount = haAmount;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}

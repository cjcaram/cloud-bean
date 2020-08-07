package com.enano.cloudbean.dtos;

public class BasicProcessDto {
  private Long id;
  private Integer processNo;
  private String referenceName;
  
  public BasicProcessDto() {
  }
  
  public BasicProcessDto(Long id, Integer processNo, String referenceName) {
    this.id = id;
    this.processNo = processNo;
    this.referenceName = referenceName;
  }
  
  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getProcessNo() {
    return processNo;
  }

  public void setProcessNo(Integer processNo) {
    this.processNo = processNo;
  }

  public String getReferenceName() {
    return referenceName;
  }

  public void setReferenceName(String referenceName) {
    this.referenceName = referenceName;
  }

  
}

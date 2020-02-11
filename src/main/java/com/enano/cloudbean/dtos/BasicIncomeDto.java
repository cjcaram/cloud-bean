package com.enano.cloudbean.dtos;

public class BasicIncomeDto {
  private Long id;
  private Integer incomeNo;
  
  public BasicIncomeDto() {
  }
  
  public BasicIncomeDto(Long id, Integer incomeNo) {
    this.id = id;
    this.incomeNo = incomeNo;
  }
  
  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getIncomeNo() {
    return incomeNo;
  }

  public void setIncomeNo(Integer incomeNo) {
    this.incomeNo = incomeNo;
  }
}

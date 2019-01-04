package com.enano.cloudbean.dtos;

import java.util.List;

public class BasicTreeViewDto {
  private Long id;
  private String name;
  private List<?> children;
  
  public BasicTreeViewDto() {
  }
  
  public BasicTreeViewDto(Long id, String name, List<?> children) {
    this.id = id;
    this.name = name;
    this.children = children;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<?> getChildren() {
    return children;
  }

  public void setChildren(List<?> children) {
    this.children = children;
  }

}

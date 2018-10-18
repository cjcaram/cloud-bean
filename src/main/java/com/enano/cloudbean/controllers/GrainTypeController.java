package com.enano.cloudbean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.entities.GrainType;
import com.enano.cloudbean.services.GrainTypeService;

@RestController
@RequestMapping("/grain-type")
public class GrainTypeController {
  @Autowired
  private GrainTypeService grainTypeService;

  @GetMapping(value = "/list")
  public List<GrainType> getUsers() {
    return grainTypeService.listAll();
  }
}

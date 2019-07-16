package com.enano.cloudbean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.entities.QualityType;
import com.enano.cloudbean.services.QualityTypeService;

@RestController
@RequestMapping("/quality-type")
public class QualityTypeController {
  @Autowired
  private QualityTypeService qualityTypeService;

  @GetMapping(value = "/list")
  public List<QualityType> getUsers() {
    return qualityTypeService.listAll();
  }
}
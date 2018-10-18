package com.enano.cloudbean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.entities.PackagingType;
import com.enano.cloudbean.services.PackagingTypeService;

@RestController
@RequestMapping("/packaging-type")
public class PackagingTypeController {

  @Autowired
  private PackagingTypeService packagingTypeService;

  @GetMapping(value = "/list")
  public List<PackagingType> getUsers() {
    return packagingTypeService.listAll();
  }
}

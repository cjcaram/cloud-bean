package com.enano.cloudbean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.entities.AgrochemicalType;
import com.enano.cloudbean.services.AgrochemicalTypeService;

@RestController
@RequestMapping("/agrochemical-type")
public class AgrochemicalTypeController {

    @Autowired
    private AgrochemicalTypeService agrochemicalTypeService;

    @GetMapping(value = "/list")
    public List<AgrochemicalType> getUsers() {
      return agrochemicalTypeService.listAll();
    }
  }

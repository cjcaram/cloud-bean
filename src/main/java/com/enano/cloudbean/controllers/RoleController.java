package com.enano.cloudbean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.entities.Role;
import com.enano.cloudbean.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
  
  @Autowired
  private RoleService roleService;

  @GetMapping(value = "/roles")
  public List<Role> getUsers() {
    return roleService.getAllRoles();
  }
  
}

package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Role;
import com.enano.cloudbean.repositories.RoleRepository;

@Service
public class RoleService {

  @Autowired
  private RoleRepository roleRepo;
  
  public List<Role> getAllRoles() {
    return roleRepo.findAll();
  }
  
}

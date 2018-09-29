package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  
  

}

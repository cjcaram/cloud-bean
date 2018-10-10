package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.entities.Location;

@Repository
public interface ComercialEntityRepository extends JpaRepository<ComercialEntity,Long> {
  
  List<ComercialEntity> findByLocation(Location location);
}


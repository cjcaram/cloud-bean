package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Agrochemical;

@Repository
public interface AgrochemicalRepository extends JpaRepository<Agrochemical, Long>{

  @Query("SELECT DISTINCT a.name FROM Agrochemical a")
  List<String> listAllDistincAgrochemicalNames();
}

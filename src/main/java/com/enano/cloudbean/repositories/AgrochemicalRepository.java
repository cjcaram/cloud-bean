package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Agrochemical;

@Repository
public interface AgrochemicalRepository extends JpaRepository<Agrochemical, Long>{

}

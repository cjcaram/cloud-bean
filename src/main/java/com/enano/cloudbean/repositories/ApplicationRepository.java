package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.AgrochemicalApplication;

@Repository
public interface AgrochemicalApplicationRepository extends JpaRepository<AgrochemicalApplication, Long>{

}

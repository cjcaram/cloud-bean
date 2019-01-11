package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.AgrochemicalAppType;

@Repository
public interface AgrochemicalAppTypeRepository extends JpaRepository<AgrochemicalAppType, Long>{

}

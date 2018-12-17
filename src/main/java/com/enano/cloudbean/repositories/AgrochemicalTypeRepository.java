package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.AgrochemicalType;

@Repository
public interface AgrochemicalTypeRepository extends JpaRepository<AgrochemicalType, Long> {

}

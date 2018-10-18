package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enano.cloudbean.entities.GrainType;

public interface GrainTypeRepository extends JpaRepository<GrainType, Long> {
}

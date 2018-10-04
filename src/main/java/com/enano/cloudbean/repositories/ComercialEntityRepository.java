package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.ComercialEntity;

@Repository
public interface ComercialEntityRepository extends JpaRepository<ComercialEntity,Long> {
}


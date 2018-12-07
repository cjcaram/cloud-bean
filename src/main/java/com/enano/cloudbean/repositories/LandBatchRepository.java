package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.LandBatch;

@Repository
public interface LandBatchRepository extends JpaRepository<LandBatch, Long> {

}

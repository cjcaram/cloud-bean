package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Analysis;

@Repository
public interface AnalysisRepository extends JpaRepository<Analysis, Long> {
}

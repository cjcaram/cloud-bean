package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Outcome;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long>{
}

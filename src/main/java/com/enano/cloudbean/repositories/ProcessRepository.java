package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<com.enano.cloudbean.entities.Process, Long> {

}

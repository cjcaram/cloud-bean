package com.enano.cloudbean.repositories;

import com.enano.cloudbean.entities.Location;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
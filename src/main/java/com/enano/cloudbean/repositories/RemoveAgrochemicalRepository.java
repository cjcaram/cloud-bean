package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.RemoveAgrochemical;

@Repository
public interface RemoveAgrochemicalRepository extends JpaRepository<RemoveAgrochemical, Long>{

}

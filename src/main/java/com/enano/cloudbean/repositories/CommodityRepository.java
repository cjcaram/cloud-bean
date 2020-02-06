package com.enano.cloudbean.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Commodity;

@Repository
public interface CommodityRepository  extends JpaRepository<Commodity, Long> {
}

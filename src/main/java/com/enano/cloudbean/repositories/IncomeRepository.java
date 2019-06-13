package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enano.cloudbean.entities.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>, IncomeRepositoryCustom {
}

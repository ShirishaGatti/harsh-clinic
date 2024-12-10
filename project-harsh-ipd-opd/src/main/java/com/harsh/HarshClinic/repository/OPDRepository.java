package com.harsh.HarshClinic.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsh.HarshClinic.model.OPD;

@Repository
public interface OPDRepository extends JpaRepository<OPD, Long> {
}

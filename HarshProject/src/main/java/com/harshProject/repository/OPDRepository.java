package com.harshProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshProject.entities.OPD;

@Repository
public interface OPDRepository extends JpaRepository<OPD, Long> {
}

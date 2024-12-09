package com.harshProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshProject.entities.PatientDetails;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, Long> {
	  Optional<PatientDetails> findByMobileNumber(String mobileNumber);
}

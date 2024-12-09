package com.harshProject.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.harshProject.entities.PatientDetails;
import com.harshProject.repository.PatientDetailsRepository;

@Service
public class PatientDetailsService {

    @Autowired
    private PatientDetailsRepository repository;

    public ResponseEntity<Map<String, Object>> createPatientDetails(PatientDetails patientDetails) {
        Map<String, Object> response = new HashMap<>();

        // Check if the mobile number already exists
        Optional<PatientDetails> existingPatient = repository.findByMobileNumber(patientDetails.getMobileNumber());
        if (existingPatient.isPresent()) {
            response.put("success", false);
            response.put("message", "Mobile number already exists.");
            return ResponseEntity.badRequest().body(response);
        }

        // Save the new patient details
        PatientDetails savedDetails = repository.save(patientDetails);
        response.put("success", true);
        response.put("message", "Patient details saved successfully.");
        response.put("data", savedDetails);
        return ResponseEntity.ok(response);
    }

    // Retrieve all patient details
    public List<PatientDetails> getAllPatientDetails() {
        return repository.findAll();
    }

  

}

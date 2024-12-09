package com.harshProject.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.harshProject.entities.PatientDetails;
import com.harshProject.repository.PatientDetailsRepository;
import com.harshProject.service.PatientDetailsService;

@RestController
@RequestMapping("/api/patient-details")
public class PatientDetailsController {

    @Autowired
    private PatientDetailsService service; 
    @Autowired
    private PatientDetailsRepository repository;
    // Create a new patient record
    @PostMapping
    public ResponseEntity<?> createPatientDetails(@RequestBody PatientDetails patientDetails) {
        return service.createPatientDetails(patientDetails);
    }

    // Get all patient details
    @GetMapping
    public ResponseEntity<List<PatientDetails>> getAllPatientDetails() {
        List<PatientDetails> allDetails = service.getAllPatientDetails();
        return ResponseEntity.ok(allDetails);
    }

    // Get a specific patient detail by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientDetailsById(@PathVariable("id") Long id) {
        Optional<PatientDetails> patientDetails = repository.findById(id);
        if (patientDetails.isEmpty()) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Patient not available with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(patientDetails.get());
    }

}
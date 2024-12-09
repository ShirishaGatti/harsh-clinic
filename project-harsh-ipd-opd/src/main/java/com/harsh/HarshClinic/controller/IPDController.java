package com.harsh.HarshClinic.controller;

import com.harsh.HarshClinic.model.IPD;
import com.harsh.HarshClinic.repository.IPDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ipd")
public class IPDController {

    @Autowired
    private IPDRepository ipdRepository;

    // Create a new IPD record
    @PostMapping
    public ResponseEntity<String> createIPD(@RequestBody IPD ipd) {
        try {
            ipdRepository.save(ipd);
            return new ResponseEntity<>("IPD record created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating IPD record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all IPD records
    @GetMapping
    public ResponseEntity<List<IPD>> getAllIPDs() {
        try {
            List<IPD> ipdList = ipdRepository.findAll();
            return new ResponseEntity<>(ipdList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a specific IPD record by ID
    @GetMapping("/{id}")
    public ResponseEntity<IPD> getIPDById(@PathVariable Long id) {
        Optional<IPD> ipdOptional = ipdRepository.findById(id);
        if (ipdOptional.isPresent()) {
            return new ResponseEntity<>(ipdOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing IPD record
    @PutMapping("/{id}")
    public ResponseEntity<String> updateIPD(@PathVariable Long id, @RequestBody IPD updatedIPD) {
        Optional<IPD> ipdOptional = ipdRepository.findById(id);
        if (ipdOptional.isPresent()) {
            IPD existingIPD = ipdOptional.get();
            existingIPD.setCasePaperNumber(updatedIPD.getCasePaperNumber());
            existingIPD.setAdmissionDate(updatedIPD.getAdmissionDate());
            existingIPD.setDischargeDate(updatedIPD.getDischargeDate());
            existingIPD.setAmount(updatedIPD.getAmount());
            existingIPD.setNotes(updatedIPD.getNotes());
            existingIPD.setCreateDate(updatedIPD.getCreateDate());
            existingIPD.setAdminId(updatedIPD.getAdminId());

            ipdRepository.save(existingIPD);
            return new ResponseEntity<>("IPD record updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("IPD record not found", HttpStatus.NOT_FOUND);
        }
    }

    // Delete an IPD record
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIPD(@PathVariable Long id) {
        try {
            ipdRepository.deleteById(id);
            return new ResponseEntity<>("IPD record deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting IPD record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.harshProject.controller;

import com.harshProject.entities.Admin;
import com.harshProject.entities.IPD;
import com.harshProject.repository.AdminRepository;
import com.harshProject.repository.IPDRepository;
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
    @Autowired
    private AdminRepository adminRepository;
    // Create a new IPD record
    @PostMapping
    public ResponseEntity<String> createIPD(@RequestBody IPD ipd) {
        try {
            // Ensure the admin object is provided and set
            if (ipd.getAdmin() == null || ipd.getAdmin().getAdminId() == null) {
                return new ResponseEntity<>("Admin information is required", HttpStatus.BAD_REQUEST);
            }
            
            // Fetch the admin from the database using the provided adminId
            Admin admin = adminRepository.findById(ipd.getAdmin().getAdminId())
                                          .orElseThrow(() -> new RuntimeException("Admin not found"));
            ipd.setAdmin(admin); // Set the admin in the IPD entity
            
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
            existingIPD.setCasePaper(updatedIPD.getCasePaper());
            existingIPD.setAdmissionDate(updatedIPD.getAdmissionDate());
            existingIPD.setDischargeDate(updatedIPD.getDischargeDate());
            existingIPD.setAmount(updatedIPD.getAmount());
            existingIPD.setNotes(updatedIPD.getNotes());
            existingIPD.setCreateDate(updatedIPD.getCreateDate());
            existingIPD.setAdmin(updatedIPD.getAdmin());

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

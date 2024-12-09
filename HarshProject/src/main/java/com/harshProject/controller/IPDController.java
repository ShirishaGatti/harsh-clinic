package com.harshProject.controller;


import com.harshProject.entities.IPD;

import com.harshProject.service.IPDService;

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
    private IPDService ipdService;

    @PostMapping
    public ResponseEntity<String> createIPD(@RequestBody IPD ipd) {
        try {
        	ipdService.createIPD(ipd);
            return new ResponseEntity<>("IPD record created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating IPD record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<IPD>> getAllIPDs() {
        try {
            List<IPD> ipdList = ipdService.getAllIPDs();
            return new ResponseEntity<>(ipdList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<IPD> getIPDById(@PathVariable Long id) {
        Optional<IPD> ipdOptional = ipdService.getIPDById(id);
        if (ipdOptional.isPresent()) {
            return new ResponseEntity<>(ipdOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateIPD(@PathVariable Long id, @RequestBody IPD updatedIPD) {
        try {
            ipdService.updateIPD(id, updatedIPD);
            return new ResponseEntity<>("IPD record updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating IPD record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIPD(@PathVariable Long id) {
        try {
            ipdService.deleteIPD(id);
            return new ResponseEntity<>("IPD record deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting IPD record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

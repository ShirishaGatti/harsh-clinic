package com.harshProject.controller;

import com.harshProject.entities.Admin;
import com.harshProject.entities.OPD;
import com.harshProject.entities.PatientDetails;
import com.harshProject.repository.AdminRepository;
import com.harshProject.repository.OPDRepository;
import com.harshProject.repository.PatientDetailsRepository;
import com.harshProject.service.OPDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opd")
public class OPDController {

    @Autowired
    private OPDService opdService;
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private PatientDetailsRepository patientDetailsRepository;
    
    @Autowired
    private OPDRepository opdRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addOPD(@RequestBody OPD opd) {
        try {
            // Check if adminId and casePaperId are provided
            if (opd.getAdmin() == null || opd.getAdmin().getAdminId() == null) {
                return new ResponseEntity<>("Admin information is required", HttpStatus.BAD_REQUEST);
            }

            if (opd.getCasePaper() == null || opd.getCasePaper().getCasePaperId() == null) {
                return new ResponseEntity<>("Case Paper information is required", HttpStatus.BAD_REQUEST);
            }

            // Fetch Admin and CasePaper from the database using their IDs
            Admin admin = adminRepository.findById(opd.getAdmin().getAdminId())
                                          .orElseThrow(() -> new RuntimeException("Admin not found"));
            opd.setAdmin(admin);

            PatientDetails casePaper = patientDetailsRepository.findById(opd.getCasePaper().getCasePaperId())
                                                          .orElseThrow(() -> new RuntimeException("Case Paper not found"));
            opd.setCasePaper(casePaper);

            // Save the OPD record
            opdRepository.save(opd);

            return new ResponseEntity<>("OPD record created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating OPD record: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





//    @PutMapping("/modify/{id}")
//    public ResponseEntity<OPD> modifyOPD(@PathVariable Long id, @RequestBody OPD updatedOpd) {
//        Optional<OPD> existingOpdOptional = opdRepository.findById(id);
//
//        if (existingOpdOptional.isPresent()) {
//            OPD existingOpd = existingOpdOptional.get();
//
//            // Set updated values from the request
//            existingOpd.setCasePaper(updatedOpd.getCasePaper());
//            existingOpd.setOpdDate(updatedOpd.getOpdDate());
//            existingOpd.setAmount(updatedOpd.getAmount());
//            existingOpd.setNote(updatedOpd.getNote());
//            existingOpd.setCreateDate(updatedOpd.getCreateDate());
//
//            // Check if admin is provided and handle the case when it's null
//            if (updatedOpd.getAdmin() != null && updatedOpd.getAdmin().getAdminId() != null) {
//                // Fetch Admin using adminId and set it
//                Optional<Admin> adminOptional = adminRepository.findById(updatedOpd.getAdmin().getAdminId());
//                if (adminOptional.isPresent()) {
//                    existingOpd.setAdmin(adminOptional.get());
//                } else {
//                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                         .body(null); // Return 404 if admin is not found
//                }
//            } else {
//                return ResponseEntity.badRequest()
//                                     .body(null); // Return 400 if admin is not provided
//            }
//
//            // Save the updated OPD
//            opdRepository.save(existingOpd);
//            return ResponseEntity.ok(existingOpd);
//        } else {
//            return ResponseEntity.notFound().build(); // Return 404 if OPD is not found
//        }
//    }



    @GetMapping("/all")
    public ResponseEntity<List<OPD>> getAllOPDs() {
        return ResponseEntity.ok(opdService.getAllOPDs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OPD> getOPDById(@PathVariable Long id) {
        OPD opd = opdService.getOPDById(id);
        if (opd != null) {
            return ResponseEntity.ok(opd);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOPD(@PathVariable Long id) {
        opdService.deleteOPD(id);
        return ResponseEntity.noContent().build();
    }
}


package com.harshProject.controller;

import com.harshProject.entities.OPD;
import com.harshProject.service.OPDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opd")
public class OPDController {

    @Autowired
    private OPDService opdService;

    @PostMapping("/add")
    public ResponseEntity<OPD> addOPD(@RequestBody OPD opd) {
        OPD createdOpd = opdService.addOPD(opd);
        return ResponseEntity.ok(createdOpd);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<OPD> modifyOPD(@PathVariable Long id, @RequestBody OPD updatedOpd) {
        OPD modifiedOpd = opdService.modifyOPD(id, updatedOpd);
        if (modifiedOpd != null) {
            return ResponseEntity.ok(modifiedOpd);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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


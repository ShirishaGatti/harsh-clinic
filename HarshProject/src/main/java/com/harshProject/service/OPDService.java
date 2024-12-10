package com.harshProject.service;


import com.harshProject.entities.OPD;
import com.harshProject.repository.OPDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OPDService {

    @Autowired
    private OPDRepository opdRepository;

    public OPD addOPD(OPD opd) {
        return opdRepository.save(opd);
    }

    public OPD modifyOPD(Long opdId, OPD updatedOpd) {
        Optional<OPD> optionalOpd = opdRepository.findById(opdId);
        if (optionalOpd.isPresent()) {
            OPD existingOpd = optionalOpd.get();
            existingOpd.setCasePaper(updatedOpd.getCasePaper());
            existingOpd.setOpdDate(updatedOpd.getOpdDate());
            existingOpd.setAmount(updatedOpd.getAmount());
            existingOpd.setNote(updatedOpd.getNote());
            existingOpd.setCreateDate(updatedOpd.getCreateDate());
            existingOpd.setAdmin(updatedOpd.getAdmin());
            return opdRepository.save(existingOpd);
        }
        return null;
    }

    public List<OPD> getAllOPDs() {
        return opdRepository.findAll();
    }

    public OPD getOPDById(Long opdId) {
        return opdRepository.findById(opdId).orElse(null);
    }

    public void deleteOPD(Long opdId) {
        opdRepository.deleteById(opdId);
    }
}

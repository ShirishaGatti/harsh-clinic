package com.harshProject.service;


import com.harshProject.entities.IPD;
import com.harshProject.repository.IPDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPDService {

    @Autowired
    private IPDRepository ipdRepository;

    // Create a new IPD record
    public IPD createIPD(IPD ipd) {
        return ipdRepository.save(ipd);
    }

    // Retrieve all IPD records
    public List<IPD> getAllIPDs() {
        return ipdRepository.findAll();
    }

    // Retrieve a specific IPD record by ID
    public Optional<IPD> getIPDById(Long id) {
        return ipdRepository.findById(id);
    }

    // Update an existing IPD record
    public IPD updateIPD(Long id, IPD updatedIPD) throws Exception {
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

            return ipdRepository.save(existingIPD);
        } else {
            throw new Exception("IPD record not found");
        }
    }

    // Delete an IPD record
    public void deleteIPD(Long id) throws Exception {
        if (ipdRepository.existsById(id)) {
            ipdRepository.deleteById(id);
        } else {
            throw new Exception("IPD record not found");
        }
    }
}

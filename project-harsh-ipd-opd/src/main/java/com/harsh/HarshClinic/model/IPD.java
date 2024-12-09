package com.harsh.HarshClinic.model;

import java.time.LocalDate;

import com.sun.istack.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class IPD {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ipdId;  
    
    @NotNull    
    private Long casePaperNumber;  
    @NotNull
    private LocalDate admissionDate;  
    @NotNull
    private LocalDate dischargeDate;  
    @NotNull
    private Double amount;  
    @NotNull
    private String notes;  
    
    @NotNull
    private LocalDate createDate;
    @NotNull
    private Long adminId;  

  
    
    public Long getIpdId() {
        return ipdId;
    }

    public void setIpdId(Long ipdId) {
        this.ipdId = ipdId;
    }

    public Long getCasePaperNumber() {
        return casePaperNumber;
    }

    public void setCasePaperNumber(Long casePaperNumber) {
        this.casePaperNumber = casePaperNumber;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    // Constructor
    public IPD() {
        // Default constructor
    }
}

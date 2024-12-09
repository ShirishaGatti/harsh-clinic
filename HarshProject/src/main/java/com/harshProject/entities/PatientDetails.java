package com.harshProject.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CM_PATIENT_DETAILS")
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CM_CASE_PAPER_ID")
    private Long casePaperId;

    @Column(name = "CM_NAME", nullable = false)
    private String name;

    @Column(name = "CM_MOBILE_NBR", nullable = false, unique = true)
    private String mobileNumber;

    @Column(name = "CM_ADDRESS")
    private String address;

    @Column(name = "CM_GENDER", nullable = false)
    private String gender;

    @Column(name = "CM_REG_DATE", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "CM_ADMIN_ID", nullable = false)
    private Long adminId;

    @Column(name = "CM_STATUS", nullable = false)
    private String status; // Active or Inactive

    @Lob
    @Column(name = "CM_NOTES")
    private String notes;

    // Getters and Setters
    public Long getCasePaperId() {
        return casePaperId;
    }

    public void setCasePaperId(Long casePaperId) {
        this.casePaperId = casePaperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

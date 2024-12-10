package com.harshProject.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CM_IPD_DTL")
public class IPD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CM_IPD_ID")
    private Long ipdId;

    @ManyToOne
    @JoinColumn(name = "CM_CASE_PAPER_ID", nullable = false) // Foreign key to CasePaper
    private PatientDetails casePaper;

    @Column(name = "CM_ADMISSOIN_DATE", nullable = false)
    private LocalDate admissionDate;

    @Column(name = "CM_DISCHARGE_DATE", nullable = false)
    private LocalDate dischargeDate;

    @Column(name = "CM_AMOUNT", nullable = false)
    private Double amount;

    @Column(name = "CM_NOTES")
    private String notes;

    @Column(name = "CM_CRE_DT", nullable = false)
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "CM_ADMIN_ID", nullable = false) // Foreign key to Admin
    private Admin admin;

	public Long getIpdId() {
		return ipdId;
	}

	public void setIpdId(Long ipdId) {
		this.ipdId = ipdId;
	}

	public PatientDetails getCasePaper() {
		return casePaper;
	}

	public void setCasePaper(PatientDetails casePaper) {
		this.casePaper = casePaper;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public IPD() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    // Getters and Setters...
}

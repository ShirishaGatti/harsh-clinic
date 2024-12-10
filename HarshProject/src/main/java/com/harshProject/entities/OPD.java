package com.harshProject.entities;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "CM_OPD_DTL")
public class OPD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CM_OPD_ID")
    private Long opdId;

    @ManyToOne    @JsonIgnore 
    @JoinColumn(name = "CM_CASE_PAPER_ID", nullable = false) // Foreign key to CasePaper
    private PatientDetails casePaper;

    @Column(name = "CM_OPD_DATE", nullable = false)
    private Date opdDate;

    @Column(name = "CM_AMOUNT", nullable = false)
    private double amount;

    @Column(name = "CM_NOTES")
    private String note;

    @Column(name = "CM_CRE_DT", nullable = false)
    private Date createDate;

    @ManyToOne   
    @JsonIgnore 
    @JoinColumn(name = "CM_ADMIN_ID", nullable = false) // Foreign key to Admin
    private Admin admin;

	public Long getOpdId() {
		return opdId;
	}

	public void setOpdId(Long opdId) {
		this.opdId = opdId;
	}
	
	 @JsonProperty("casePaper")
	public PatientDetails getCasePaper() {
		return casePaper;
	}

	public void setCasePaper(PatientDetails casePaper) {
		this.casePaper = casePaper;
	}

	public Date getOpdDate() {
		return opdDate;
	}

	public void setOpdDate(Date opdDate) {
		this.opdDate = opdDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@JsonProperty("adminId")
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public OPD() {
		super();
		// TODO Auto-generated constructor stub
	}

    
    
    // Getters and Setters...
}

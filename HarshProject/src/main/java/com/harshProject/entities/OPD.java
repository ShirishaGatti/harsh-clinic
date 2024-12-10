package com.harshProject.entities;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class OPD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opdId;

    private int casePaperNo;
    private Date opdDate;
    private double amount;
    private String note;
    private Date createDate;
    private Long adminId;

    // Getters and Setters
    public Long getOpdId() {
        return opdId;
    }

    public void setOpdId(Long opdId) {
        this.opdId = opdId;
    }

    public int getCasePaperNo() {
        return casePaperNo;
    }

    public void setCasePaperNo(int casePaperNo) {
        this.casePaperNo = casePaperNo;
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}

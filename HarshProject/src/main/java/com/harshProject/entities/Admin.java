package com.harshProject.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "CM_USER")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CM_ADMIN_ID")
    private Long adminId;

    @Column(name = "CM_NAME", nullable = false)
    private String name;

    @Column(name = "CM_MOBILE_NUMBER", nullable = false, unique = true)
    private String mobileNumber;

    @Column(name = "CM_USER_ID", nullable = false, unique = true)
    private String userId;

    @Column(name = "CM_PASSWORD", nullable = false)
    private String password;

    @Column(name = "CM_STATUS", nullable = false)
    private String status; // Active/Inactive

    // Getters and Setters
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

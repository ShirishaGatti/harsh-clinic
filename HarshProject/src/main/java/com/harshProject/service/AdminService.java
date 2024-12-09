package com.harshProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshProject.entities.Admin;
import com.harshProject.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Admin Registration
    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Admin Login
    public Admin login(String userId, String password) {
        return adminRepository.findByUserIdAndPassword(userId, password);
    }
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);  // Or you can throw an exception if preferred
    }
    public boolean isMobileNumberExists(String mobileNumber) {
        return adminRepository.existsByMobileNumber(mobileNumber);
    }
    public boolean isUserIdExists(String userId) {
        return adminRepository.existsByUserId(userId);
    }

}

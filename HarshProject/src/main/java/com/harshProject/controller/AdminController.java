package com.harshProject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.harshProject.entities.Admin;
import com.harshProject.entities.LoginRequest;
import com.harshProject.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin Registration
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerAdmin(@RequestBody Admin admin) {
        Map<String, String> response = new HashMap<>();
        
        // Check if mobile number already exists
        if (adminService.isMobileNumberExists(admin.getMobileNumber())) {
            response.put("status", "error");
            response.put("message", "Mobile number already exists.");
            return ResponseEntity.status(400).body(response);  // 400 Bad Request
        }

        // Check if userId already exists
        if (adminService.isUserIdExists(admin.getUserId())) {
            response.put("status", "error");
            response.put("message", "User ID already exists.");
            return ResponseEntity.status(400).body(response);  // 400 Bad Request
        }

        // Proceed with registration
        Admin savedAdmin = adminService.registerAdmin(admin);
        response.put("status", "success");
        response.put("message", "Admin registered successfully!");
        response.put("adminId", String.valueOf(savedAdmin.getAdminId()));  // Optional, if you want to return the ID
        return ResponseEntity.ok(response);
    }


    // Admin Login
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();

        Map<String, String> response = new HashMap<>();
        
        Admin admin = adminService.login(userId, password);
        if (admin != null && "Active".equalsIgnoreCase(admin.getStatus())) {
            response.put("status", "success");
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response);
        } else if (admin != null && !"Active".equalsIgnoreCase(admin.getStatus())) {
            response.put("status", "error");
            response.put("message", "Account is inactive.");
            return ResponseEntity.status(403).body(response);
        } else {
            response.put("status", "error");
            response.put("message", "Invalid credentials.");
            return ResponseEntity.status(401).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAdminById(@PathVariable("id") Long id) {
        Map<String, Object> response = new HashMap<>();
        
        Admin admin = adminService.getAdminById(id);
        if (admin != null) {
            response.put("status", "success");
            response.put("data", admin);
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Admin not found with ID: " + id);
            return ResponseEntity.ok(response);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllAdmins() {
        Map<String, Object> response = new HashMap<>();
        
        List<Admin> admins = adminService.getAllAdmins();
        if (!admins.isEmpty()) {
            response.put("status", "success");
            response.put("data", admins);
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "No admins found.");
            return ResponseEntity.ok(response);
        }
    }
    
}
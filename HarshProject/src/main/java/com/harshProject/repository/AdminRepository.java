package com.harshProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshProject.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUserIdAndPassword(String userId, String password);
    boolean existsByMobileNumber(String mobileNumber);
    boolean existsByUserId(String userId);
}
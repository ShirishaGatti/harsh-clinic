package com.harshProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshProject.entities.IPD;

@Repository
public interface IPDRepository extends JpaRepository<IPD, Long> {
    // You can define custom queries here if needed, e.g., search by case paper number
}

package com.harshProject.repository;

import com.harshProject.entities.IPD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPDRepository extends JpaRepository<IPD, Long> {
    // You can define custom queries here if needed, e.g., search by case paper number
}

package com.harshProject.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harshProject.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Additional custom queries (if needed) can be defined here
}


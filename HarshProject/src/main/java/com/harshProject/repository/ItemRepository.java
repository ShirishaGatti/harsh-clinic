package com.harshProject.repository;



import  com.harshProject.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Additional custom queries (if needed) can be defined here
}


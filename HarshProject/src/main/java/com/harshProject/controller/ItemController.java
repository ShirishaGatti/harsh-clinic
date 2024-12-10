package com.harshProject.controller;


import com.harshProject.entities.Item;
import com.harshProject.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Create a new Item
    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody Item item) {
        try {
            itemService.createItem(item);
            return new ResponseEntity<>("Item created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating item: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Retrieve all Items
    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        try {
            List<Item> items = itemService.getAllItems();
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Retrieve an Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> itemOptional = itemService.getItemById(id);
        if (itemOptional.isPresent()) {
            return new ResponseEntity<>(itemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an Item
    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        try {
            itemService.updateItem(id, updatedItem);
            return new ResponseEntity<>("Item updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating item: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete an Item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        try {
            itemService.deleteItem(id);
            return new ResponseEntity<>("Item deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting item: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


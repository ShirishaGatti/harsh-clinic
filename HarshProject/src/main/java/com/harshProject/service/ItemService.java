package com.harshProject.service;



import com.harshProject.entities.Item;
import com.harshProject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Create a new Item
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // Retrieve all Items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Retrieve an Item by ID
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Update an Item
    public Item updateItem(Long id, Item updatedItem) throws Exception {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item existingItem = itemOptional.get();
            existingItem.setDiscountPercentage(updatedItem.getDiscountPercentage());
            existingItem.setCreateDate(updatedItem.getCreateDate());
            existingItem.setStatus(updatedItem.getStatus());
            existingItem.setAdmin(updatedItem.getAdmin());
            return itemRepository.save(existingItem);
        } else {
            throw new Exception("Item not found");
        }
    }

    // Delete an Item by ID
    public void deleteItem(Long id) throws Exception {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        } else {
            throw new Exception("Item not found");
        }
    }
}

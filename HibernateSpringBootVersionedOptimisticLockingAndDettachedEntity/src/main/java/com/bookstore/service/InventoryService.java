package com.bookstore.service;

import com.bookstore.entity.Inventory;
import com.bookstore.repository.InventoryRepository;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory firstTransactionFetchesAndReturn() {
        Inventory firstInventory = inventoryRepository.findById(1L).orElseThrow();

        return firstInventory;
    }       

    public void secondTransactionMergesAndUpdates(Inventory firstInventory) {        
        inventoryRepository.save(firstInventory); // calls EntityManager#merge() behind the scene                
    }
}

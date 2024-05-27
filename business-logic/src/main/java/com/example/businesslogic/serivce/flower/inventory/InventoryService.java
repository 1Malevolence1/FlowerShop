package com.example.businesslogic.serivce.flower.inventory;

import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.models.flower.inventory.Inventory;
import com.example.businesslogic.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void saveBaseDateInventory(Inventory inventory){
        inventoryRepository.save(inventory);
        log.info("Сохранили интвентарь {}", inventory);
    }
}

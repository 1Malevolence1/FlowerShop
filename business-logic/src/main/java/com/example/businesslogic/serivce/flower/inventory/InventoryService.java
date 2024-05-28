package com.example.businesslogic.serivce.flower.inventory;

import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.models.flower.inventory.Inventory;
import com.example.businesslogic.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public void saveBaseDateInventory(Inventory inventory){
        inventoryRepository.save(inventory);
        log.info("Сохранили интвентарь {}", inventory);
    }


    public void saveBaseDataInventory(Flower flower, NewFlowerDTO payload){
        try {
            Inventory inventory =   new Inventory( flower, payload.getAccountingQuantity(), payload.getActualQuantity());
            saveBaseDateInventory(inventory);
        } catch (DataIntegrityViolationException exception){
            throw new IllegalArgumentException("Ошибка в sql в инвентаре ", exception);
        }


    }
}

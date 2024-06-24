package com.example.businesslogic.serivce.flower.individual_flower.inventory;

import com.example.businesslogic.dto.inventory.InventoryDto;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.models.flower.inventory.Inventory;
import com.example.businesslogic.repository.FlowerRepository;
import com.example.businesslogic.repository.InventoryRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class InventoryService extends AbstractManagerBaseDate<InventoryDto, Void, Inventory> {

    private final InventoryRepository inventoryRepository;
    private final FlowerRepository flowerRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, FlowerRepository flowerRepository) {
        super(inventoryRepository);
        this.inventoryRepository = inventoryRepository;
        this.flowerRepository = flowerRepository;
    }



    @Override
    public void saveEntityNotReturnObject(InventoryDto dto) {
        Flower flower = flowerRepository.findById(dto.getFlowerId()).orElseThrow(() -> new NoSuchElementException());
        inventoryRepository.save(new Inventory(null, flower, dto.getAccountingQuantity(), dto.getActualQuantity()));
    }
}

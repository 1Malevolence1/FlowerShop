package com.example.businesslogic.serivce.flower.individual_flower.inventory;

import com.example.businesslogic.dto.inventory.InventoryDto;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.models.flower.inventory.Inventory;
import com.example.businesslogic.repository.InventoryRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryService extends AbstractManagerBaseDate<InventoryDto, Void, Inventory> {

    private final InventoryRepository inventoryRepository;
    private final SettingInventory settingInventory;
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, SettingInventory settingInventory) {
        super(inventoryRepository);
        this.inventoryRepository = inventoryRepository;
        this.settingInventory = settingInventory;
    }



    @Override
    public Inventory saveEntityReturnObject(InventoryDto dto) {
        InventoryDto inventoryDto = settingInventory.settingParameter(dto);
        return inventoryRepository.save(new Inventory(null, inventoryDto.getAccountingQuantity(), inventoryDto.getActualQuantity()));
    }

    public Inventory build(InventoryDto dto){
        return new Inventory().builder().accountingQuantity(dto.getAccountingQuantity()).actualQuantity(dto.getActualQuantity()).build();
    }
}

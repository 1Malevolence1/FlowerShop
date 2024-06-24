package com.example.businesslogic.serivce.flower.individual_flower.inventory;

import com.example.businesslogic.dto.inventory.InventoryDto;
import com.example.businesslogic.dto.supplier.ContactDto;
import org.springframework.stereotype.Component;

@Component
public class SettingInventory {

    public InventoryDto settingParameter(InventoryDto inventoryDto){
        return new InventoryDto(inventoryDto.getAccountingQuantity(), inventoryDto.getActualQuantity());
    }
}

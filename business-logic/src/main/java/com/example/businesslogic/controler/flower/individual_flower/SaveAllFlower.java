package com.example.businesslogic.controler.flower.individual_flower;

import com.example.businesslogic.controler.flower.SaveAll;
import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.inventory.InventoryDto;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.serivce.flower.individual_flower.inventory.InventoryService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaveAllFlower implements SaveAll<Flower, NewFlowerDTO> {

    private final FlowerControllerHelper flowerRestControllerHelper;
    private final InventoryService inventoryService;

    public SaveAllFlower(FlowerControllerHelper flowerRestControllerHelper, InventoryService inventoryService) {
        this.flowerRestControllerHelper = flowerRestControllerHelper;
        this.inventoryService = inventoryService;
    }

    @Override
    @Transactional
    public Flower saveAll(NewFlowerDTO dto) {
        Flower flower = flowerRestControllerHelper.checkSaveEntityBaseDateReturnObject(dto);
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setFlowerId(flower.getId());
        inventoryDto.setActualQuantity(dto.getInventory().getActualQuantity());
        inventoryDto.setAccountingQuantity(dto.getInventory().getAccountingQuantity());
        inventoryService.saveEntityNotReturnObject(inventoryDto);
        return flower;
    }
}

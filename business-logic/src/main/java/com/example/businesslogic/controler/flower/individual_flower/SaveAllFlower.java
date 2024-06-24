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


    public SaveAllFlower(FlowerControllerHelper flowerRestControllerHelper) {
        this.flowerRestControllerHelper = flowerRestControllerHelper;
    }

    @Override
    @Transactional
    public Flower saveAll(NewFlowerDTO dto) {
        Flower flower = flowerRestControllerHelper.checkSaveEntityBaseDateReturnObject(dto);
        return flower;
    }
}

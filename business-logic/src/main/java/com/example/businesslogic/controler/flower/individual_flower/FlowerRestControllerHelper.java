package com.example.businesslogic.controler.flower.individual_flower;


import com.example.businesslogic.controler.flower.ControllerHelper;
import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class FlowerRestControllerHelper extends ControllerHelper<NewFlowerDTO, UpdateFlowerDTO, Flower, Long> {


    private final FlowerService flowerService;


    @Override
    protected Flower createEntity(NewFlowerDTO newEntity) {
       try {
           return flowerService.createFlower(newEntity);

       } catch (NoSuchElementException exception) {
           throw new IllegalArgumentException("Flower not found:" + newEntity.getSupplierName(), exception);

       } catch (DataIntegrityViolationException exception) {
           throw new IllegalArgumentException("Цветок с таким названием уже существует", exception);
       }
    }

    @Override
    protected void  updateEntityReturnVoid(UpdateFlowerDTO payload, Long id) {
        try {
            flowerService.updateFlower(id , payload);
        } catch (DataIntegrityViolationException exception){
            throw new IllegalArgumentException("Цветок с таким названием уже существуте", exception);
        }
    }
}

package com.example.businesslogic.controler.flower.type_flower;


import com.example.businesslogic.controler.flower.ControllerHelper;
import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeFlowerControllerHelper extends ControllerHelper<NewTypeFlowerDTO, Void, TypeFlower ,Long> {

    private final TypeFlowerService typeFlowerService;



    @Override
    public void createEntityReturnVoid(NewTypeFlowerDTO newEntity) {
        try {
            typeFlowerService.saveBaseDateTypeFlower(newEntity);
        } catch (DataIntegrityViolationException exception) {
            throw new IllegalArgumentException("Тип с таким названием уже сущестует", exception);
        }
    }
}

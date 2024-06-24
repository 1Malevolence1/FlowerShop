package com.example.businesslogic.controler.flower.type_flower;


import com.example.businesslogic.controler.flower.AbstractControllerHelper;
import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeFlowerAbstractControllerHelper extends AbstractControllerHelper<NewTypeFlowerDTO, Void, TypeFlower> {

   @Autowired
    public TypeFlowerAbstractControllerHelper(TypeFlowerService service) {
        super(service);
    }
}

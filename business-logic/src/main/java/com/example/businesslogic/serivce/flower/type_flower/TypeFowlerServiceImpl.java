package com.example.businesslogic.serivce.flower.type_flower;

import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;

import java.util.List;

public interface TypeFowlerServiceImpl<DtoNew, Model> {

    List<TypeFlower> findAllEntityFormBaseDate();

    void saveEntityFromBaseDateNotReturnObject(NewTypeFlowerDTO object);

    void deleteEntityFromBaseDateById(Long id);

    TypeFlower findObject(String title);
}

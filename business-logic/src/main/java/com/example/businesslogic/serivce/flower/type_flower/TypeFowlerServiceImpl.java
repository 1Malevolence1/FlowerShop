package com.example.businesslogic.serivce.flower.type_flower;

import com.example.businesslogic.models.flower.TypeFlower;

import java.util.List;

public interface TypeFowlerServiceImpl<DtoNew, Model> {

    List<TypeFlower> findAllEntityFormBaseDate();

    void saveEntityFromBaseDateNotReturnObject(DtoNew object);

    void deleteEntityFromBaseDateById(Long id);

    Model findObject(String title);
}

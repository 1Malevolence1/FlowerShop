package com.example.businesslogic.serivce.flower;

import com.example.businesslogic.dto.flowers.CountAll;

import java.util.List;

public interface ManagerBaseDate<DtoNew, UpdateDto, Model> {

    List<Model> findAllEntity();

    Model findByName(String title);


    void saveEntityNotReturnObject(DtoNew object);
    void saveEntityNotReturnObject();

    Model saveEntityReturnObject(DtoNew dtoNew);
    Model saveEntityReturnObject();

    void deleteEntityById(Long id);

    void updateEntity(UpdateDto dtoUpdate, Long id);

    Model findById(Long id);

    CountAll countAll();
}

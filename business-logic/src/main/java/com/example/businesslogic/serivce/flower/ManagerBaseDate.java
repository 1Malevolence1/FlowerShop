package com.example.businesslogic.serivce.flower;

import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.individual_flower.supplier.UpdateSupplierDTO;
import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.models.flower.suppliers.Supplier;

import java.util.List;

public interface ManagerBaseDate<DtoNew, UpdateDto, Model> {

    List<Model> findAllEntityFormBaseDate();

    Model findByName(String title);


    void saveEntityFromBaseDateNotReturnObject(DtoNew object);

    Model saveEntityFromBaseDateReturnObject(DtoNew dtoNew);

    void deleteEntityFromBaseDateById(Long id);

    void updateEntityFromBaseDate(UpdateDto dtoUpdate, Long id);

    Model findById(Long id);
}

package com.example.businesslogic.serivce.flower;

import com.example.businesslogic.dto.supplier.NewSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;

import java.util.List;

public interface CrudService<newObject, updateObject , modelObject, ID> {
    modelObject create(newObject object);

    void update(updateObject updateObject, Long id);

    void delete (ID id);

    List<modelObject> findAll();

    modelObject find(ID id);

}

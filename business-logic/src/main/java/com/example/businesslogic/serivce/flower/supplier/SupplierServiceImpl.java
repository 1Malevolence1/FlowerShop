package com.example.businesslogic.serivce.flower.supplier;

import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.individual_flower.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;

import java.util.List;

public interface SupplierServiceImpl {
    List<Supplier> findAllEntityFormBaseDate();

    Supplier saveEntityFromBaseDateReturnObject(NewSupplierDTO dtoNew);

    void deleteEntityFromBaseDateById(Long id);

    void updateEntityFromBaseDate(UpdateSupplierDTO dtoUpdate, Long id);

    Supplier getSupplierBaseData(String name);

    Supplier find(Long id);
}

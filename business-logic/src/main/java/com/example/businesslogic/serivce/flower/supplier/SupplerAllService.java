package com.example.businesslogic.serivce.flower.supplier;

import com.example.businesslogic.controler.flower.ContactControllerHelperImpl;
import com.example.businesslogic.controler.flower.SaveAll;
import com.example.businesslogic.controler.flower.supplier.SupplierControllerHelper;
import com.example.businesslogic.dto.supplier.NewSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class SupplerAllService implements SaveAll<Supplier, NewSupplierDTO> {

    private SupplierControllerHelper supplierControllerHelper;
    private ContactControllerHelperImpl contactControllerHelper;

    @Autowired
    public SupplerAllService(SupplierControllerHelper supplierControllerHelper, ContactControllerHelperImpl contactControllerHelper) {
        this.supplierControllerHelper = supplierControllerHelper;
        this.contactControllerHelper = contactControllerHelper;
    }

    @Override
    @Transactional
    public Supplier saveAll(NewSupplierDTO dto) {
        Supplier supplier = supplierControllerHelper.checkSaveEntityBaseDateReturnObject(dto);
        dto.getContact().setSupplierId(supplier.getId());
        contactControllerHelper.checkSaveEntityBaseDateNotReturnObject(dto.getContact());
        return supplier;
    }
}


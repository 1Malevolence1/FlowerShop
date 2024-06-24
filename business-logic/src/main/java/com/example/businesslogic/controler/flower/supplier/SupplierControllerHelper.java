package com.example.businesslogic.controler.flower.supplier;

import com.example.businesslogic.controler.flower.AbstractControllerHelper;
import com.example.businesslogic.dto.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.serivce.flower.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SupplierControllerHelper extends AbstractControllerHelper<NewSupplierDTO, UpdateSupplierDTO, Supplier> {

    @Autowired
    public SupplierControllerHelper(SupplierService service) {
        super(service);
    }
}

package com.example.businesslogic.controler.flower.supplier;

import com.example.businesslogic.controler.flower.AbstractControllerHelper;
import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.individual_flower.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.serivce.flower.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SupplierAbstractControllerHelper extends AbstractControllerHelper<NewSupplierDTO, UpdateSupplierDTO, Supplier> {

    @Autowired
    public SupplierAbstractControllerHelper(SupplierService service) {
        super(service);
    }
}

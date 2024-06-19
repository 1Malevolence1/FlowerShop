package com.example.businesslogic.controler.flower.supplier;

import com.example.businesslogic.controler.flower.ControllerHelper;
import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.individual_flower.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.serivce.flower.supplier.SupplierService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;


@Component
public class SupplierControllerHelper extends ControllerHelper<NewSupplierDTO, UpdateSupplierDTO, Supplier, Long> {

    private final SupplierService supplierService;

    public SupplierControllerHelper(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public void updateEntityReturnVoid(UpdateSupplierDTO object, Long id) {
        try {
            supplierService.updateEntityFromBaseDate(object, id);
        } catch (DataIntegrityViolationException exception) {
            throw new IllegalArgumentException("Паставщик с таким названием уже существует");
        }
    }

@Override
public Supplier createEntity(NewSupplierDTO newEntity) {
    try {
        return supplierService.saveEntityFromBaseDateReturnObject(newEntity);
    } catch (DataIntegrityViolationException exception) {
       switch (exception.getMessage()){
           case "suppliers_supplier_name_key" ->  throw new IllegalArgumentException("Поставщик с таким названием уже существует", exception);
           default -> throw new IllegalArgumentException("Не удалось занести поставщика в базу данных", exception);
       }
    }
}

}

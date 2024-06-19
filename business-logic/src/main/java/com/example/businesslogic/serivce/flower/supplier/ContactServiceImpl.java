package com.example.businesslogic.serivce.flower.supplier;

import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Contact;
import com.example.businesslogic.models.flower.suppliers.Supplier;

public interface ContactServiceImpl {
    void saveDataBaseContact(NewSupplierDTO dto, Supplier supplier);
}

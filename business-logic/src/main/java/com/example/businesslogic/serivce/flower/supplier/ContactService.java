package com.example.businesslogic.serivce.flower.supplier;

import com.example.businesslogic.dto.supplier.ContactDto;
import com.example.businesslogic.models.flower.suppliers.Contact;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.ContactRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService extends AbstractManagerBaseDate<ContactDto, Void, Contact> {

    private final ContactRepository contactRepository;
    private final SupplierService supplierService;

    @Autowired
    public ContactService(ContactRepository contactRepository, SupplierService supplierService) {
        super(contactRepository);
        this.contactRepository = contactRepository;
        this.supplierService = supplierService;
    }

    @Override
    @SneakyThrows
    public void saveEntityNotReturnObject(ContactDto dto) {
        Supplier supplier = supplierService.findById(dto.getSupplierId());
        contactRepository.save(new Contact(null, dto.getContactName(), dto.getContactPhone(), dto.getEmail(), supplier));
    }
}

package com.example.businesslogic.serivce.flower.supplier;

import com.example.businesslogic.dto.supplier.NewSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Contact;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }



    public Contact saveDataBaseContact(NewSupplierDTO dto){
        return contactRepository.save(new Contact(dto.getContact().getName(), dto.getContact().getPhone(), dto.getContact().getEmail()));

    }
}

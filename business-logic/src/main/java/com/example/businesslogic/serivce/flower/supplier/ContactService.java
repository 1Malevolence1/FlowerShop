package com.example.businesslogic.serivce.flower.supplier;

import com.example.businesslogic.dto.supplier.ContactDto;
import com.example.businesslogic.models.flower.suppliers.Contact;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.ContactRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import com.example.businesslogic.serivce.flower.Builder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService implements Builder<Contact, ContactDto> {

    @Override
    public Contact build(ContactDto dto){
        return Contact.builder().id(null).contactName(dto.getContactName()).
                contactPhone(dto.getContactPhone()).email(dto.getEmail()).build();
    }
}

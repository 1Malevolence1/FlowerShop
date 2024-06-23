package com.example.businesslogic.controler.flower;

import com.example.businesslogic.dto.individual_flower.supplier.ContactDto;
import com.example.businesslogic.models.flower.suppliers.Contact;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import com.example.businesslogic.serivce.flower.supplier.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactControllerHelperImpl extends AbstractControllerHelper<ContactDto, Void, Contact > {

    @Autowired
    public ContactControllerHelperImpl(ContactService service) {
        super(service);
    }
}

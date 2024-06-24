package com.example.businesslogic.serivce.flower.supplier;


import com.example.businesslogic.dto.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.SuppliersRepository;

import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class SupplierService extends AbstractManagerBaseDate<NewSupplierDTO, UpdateSupplierDTO, Supplier> {


    private final SuppliersRepository suppliersRepository;
    private final ContactService contactService;

    @Autowired
    public SupplierService(SuppliersRepository suppliersRepository, ContactService contactService) {
        super(suppliersRepository);
        this.suppliersRepository = suppliersRepository;
        this.contactService = contactService;
    }

    @Override
    @Transactional
    public Supplier saveEntityReturnObject(NewSupplierDTO dto) {
        Supplier supplier = suppliersRepository.save( new Supplier(null,
                 dto.getSupplierName(),
                 dto.getCity(),
                 dto.getAddress(),
                 null));
        contactService.saveEntityNotReturnObject(dto.getContact(), supplier);
        return supplier;
    }


    @Override
    public void updateEntity(UpdateSupplierDTO updateDTO, Long id) {
             suppliersRepository.findById(id).ifPresentOrElse(
                     updateSupplier -> {
                         updateSupplier.setSupplierName(updateDTO.getSupplierName());
                         updateSupplier.setCity(updateDTO.getCity());
                         updateSupplier.setAddress(updateDTO.getAddress());
                         updateSupplier.getContact().setEmail(updateDTO.getContact().getEmail());
                         updateSupplier.getContact().setContactPhone(updateDTO.getContact().getContactPhone());
                         updateSupplier.getContact().setContactName(updateDTO.getContact().getContactName());
                     }, () -> new NoSuchElementException("Supplier not found with id: " + id));

    }

    @Override
    public Supplier findByName(String title) {
        return suppliersRepository.findBySupplierName(title).orElseThrow(() -> new NoSuchElementException());
    }

    /*    private Supplier saveSuppler(NewSupplierDTO dto) {
        try {
            return savaDataBaseSupplier(dto);
        } catch (DataIntegrityViolationException exception) {
            String errors = exception.getMessage();
            if(errors.contains("suppliers_supplier_name_key")) {
                throw new IllegalArgumentException("Поставщик с таким названием уже существует", exception);
            }
            else {
                throw new IllegalArgumentException("Не удалось занести поставщика в базу данных", exception);
            }
        }
    }*/
}

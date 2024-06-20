package com.example.businesslogic.serivce.flower.supplier;


import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.individual_flower.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.SuppliersRepository;

import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public Supplier saveEntityFromBaseDateReturnObject(NewSupplierDTO dto) {
         Supplier supplier = suppliersRepository.save( new Supplier(null,
                 dto.getSupplierName(),
                 dto.getCity(),
                 dto.getAddress(),
                 null));
       contactService.saveDataBaseContact(dto, supplier);
       return supplier;
    }


    @Override
    public void updateEntityFromBaseDate(UpdateSupplierDTO updateDTO, Long id) {
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
    @Transactional
    public void deleteEntityFromBaseDateById(Long id) {
            suppliersRepository.deleteById(id);
    }


    @Override
    public List<Supplier> findAllEntityFormBaseDate() {
        return suppliersRepository.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return suppliersRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Supplier not found with id: " + id));
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

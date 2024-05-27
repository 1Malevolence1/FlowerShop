package com.example.businesslogic.serivce.flower.supplier;


import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.individual_flower.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Contact;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.SuppliersRepository;
import com.example.businesslogic.serivce.flower.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SupplierService implements CrudService<NewSupplierDTO, UpdateSupplierDTO, Supplier, Long> {


    private final SuppliersRepository suppliersRepository;

    private final ContactService contactService;

    @Autowired
    public SupplierService(SuppliersRepository suppliersRepository, ContactService contactService) {
        this.suppliersRepository = suppliersRepository;
        this.contactService = contactService;
    }

    @Override
    @Transactional
    public Supplier create(NewSupplierDTO dto) {
       Supplier supplier = saveSuppler(dto);
       saveDataBaseContact(dto, supplier);
       return supplier;
    }


    @Override
    @Transactional
    public void update(UpdateSupplierDTO updateDTO, Long id) {
        suppliersRepository.findById(id).ifPresentOrElse(
                  updateSupplier -> {
                      updateSupplier.setSupplierName(updateDTO.getSupplierName());
                      updateSupplier.setCity(updateDTO.getCity());
                      updateSupplier.setAddress(updateDTO.getAddress());
                      updateSupplier.getContact().setEmail(updateDTO.getContact().getEmail());
                      updateSupplier.getContact().setContactPhone(updateDTO.getContact().getContactPhone());
                      updateSupplier.getContact().setContactName(updateDTO.getContact().getContactName());
                  }, () -> new NoSuchElementException());
      }

    @Override
    @Transactional
    public void delete(Long id) {
            suppliersRepository.deleteById(id);
    }


    @Override
    public List<Supplier> findAll() {
        return suppliersRepository.findAll();
    }

    @Override
    @Transactional
    public Supplier find(Long id) {
        return suppliersRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }


    private Supplier saveSuppler(NewSupplierDTO dto) {
        try {
            return savaDataBaseSupplier(dto);
        } catch (DataIntegrityViolationException exception) {
            throw exception;
        }
    }


    private Supplier savaDataBaseSupplier(NewSupplierDTO dto) {
        return suppliersRepository.save( new Supplier(null,
                dto.getSupplierName(),
                dto.getCity(),
                dto.getAddress(),
                null));
    }

    private Contact saveDataBaseContact(NewSupplierDTO dto, Supplier supplier) {
        return contactService.saveDataBaseContact(dto, supplier);
    }

    public Supplier findSupplierName(String name){
        return suppliersRepository.findBySupplierName(name);
    }
}

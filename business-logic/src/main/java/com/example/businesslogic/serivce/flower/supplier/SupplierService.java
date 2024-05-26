package com.example.businesslogic.serivce.flower.supplier;


import com.example.businesslogic.dto.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Suppliers;
import com.example.businesslogic.repository.SuppliersRepository;
import com.example.businesslogic.serivce.flower.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SupplierService implements CrudService<NewSupplierDTO, UpdateSupplierDTO, Suppliers,Long> {


    private final SuppliersRepository suppliersRepository;

    @Autowired
    public SupplierService(SuppliersRepository suppliersRepository) {
        this.suppliersRepository = suppliersRepository;
    }

    @Override
    @Transactional
    public void crate(NewSupplierDTO dto) {
        suppliersRepository.save(new Suppliers(null,
                dto.getSupplierName(),
                dto.getCity(),
                dto.getContactPhone(),
                dto.getContactEmail(),
                dto.getAddress()));
    }

    @Override
    public void update(UpdateSupplierDTO updateDTO) {
        suppliersRepository.findById(updateDTO.getId()).ifPresentOrElse(
                  updateSupplier -> {
                      updateSupplier.setSupplierName(updateSupplier.getSupplierName());
                      updateSupplier.setCity(updateDTO.getCity());
                      updateSupplier.setAddress(updateDTO.getAddress());
                      updateSupplier.setContactEmail(updateDTO.getContactEmail());
                      updateSupplier.setContactPhone(updateDTO.getContactPhone());
                  }, () -> new NoSuchElementException());
      }

    @Override
    @Transactional
    public void delete(Long id) {
        suppliersRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Suppliers> findAll() {
        return suppliersRepository.findAll();
    }

    @Override
    @Transactional
    public Suppliers find(Long id) {
        return suppliersRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }
}

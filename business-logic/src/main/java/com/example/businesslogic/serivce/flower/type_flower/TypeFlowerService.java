package com.example.businesslogic.serivce.flower.type_flower;

import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.dto.individual_flower.supplier.UpdateSupplierDTO;
import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.TypeFlowerRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
    @Slf4j
public class TypeFlowerService extends AbstractManagerBaseDate<NewTypeFlowerDTO, Void, TypeFlower> {

        private final TypeFlowerRepository typeFlowerRepository;


        @Autowired
        public TypeFlowerService(TypeFlowerRepository typeFlowerRepository) {
            super(typeFlowerRepository);
            this.typeFlowerRepository = typeFlowerRepository;
        }

        @Override
        public void saveEntityNotReturnObject(NewTypeFlowerDTO dto) {
             TypeFlower typeFlower = new TypeFlower(null, dto.getType(), dto.getDescription());
             typeFlowerRepository.save(typeFlower);
        }
    }
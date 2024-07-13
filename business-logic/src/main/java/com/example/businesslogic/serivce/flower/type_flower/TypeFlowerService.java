package com.example.businesslogic.serivce.flower.type_flower;

import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.repository.TypeFlowerRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class TypeFlowerService extends AbstractManagerBaseDate<NewTypeFlowerDTO, Void, TypeFlower>   {

        private final TypeFlowerRepository typeFlowerRepository;


        @Autowired
        public TypeFlowerService(TypeFlowerRepository typeFlowerRepository) {
            super(typeFlowerRepository);
            this.typeFlowerRepository = typeFlowerRepository;
        }

    @Override
    public void saveEntityNotReturnObject(NewTypeFlowerDTO object) {
        typeFlowerRepository.save(new TypeFlower(null, object.getType(), object.getDescription()));
    }

    @Override
    public TypeFlower findByName(String title) {
        return typeFlowerRepository.findByTypeName(title).orElseThrow(() -> new NoSuchElementException());
    }
}
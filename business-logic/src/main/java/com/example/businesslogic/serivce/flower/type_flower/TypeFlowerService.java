package com.example.businesslogic.serivce.flower.type_flower;

import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.repository.TypeFlowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class TypeFlowerService implements TypeFowlerServiceImpl<NewTypeFlowerDTO, TypeFlower> {

    private final TypeFlowerRepository typeFlowerRepository;

    @Autowired
    public TypeFlowerService(TypeFlowerRepository typeFlowerRepository) {
        this.typeFlowerRepository = typeFlowerRepository;
    }

    @Override
    public List<TypeFlower> findAllEntityFormBaseDate(){
        return typeFlowerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEntityFromBaseDateNotReturnObject(NewTypeFlowerDTO dto) {
        TypeFlower typeFlower = new TypeFlower(null, dto.getType(), dto.getDescription());
         typeFlowerRepository.save(typeFlower);
    }

    @Override
    @Transactional
    public void deleteEntityFromBaseDateById(Long id) {
        typeFlowerRepository.deleteById(id);
    }

    @Override
    public TypeFlower findObject(String  title) {
        log.info(title);
        return typeFlowerRepository.findByTypeName(title).orElseThrow(() -> new NoSuchElementException());
    }
}
package com.example.businesslogic.serivce.flower.type_flower;

import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.repository.TypeFlowerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class TypeFlowerService {

    private final TypeFlowerRepository typeFlowerRepository;

    @Autowired
    public TypeFlowerService(TypeFlowerRepository typeFlowerRepository) {
        this.typeFlowerRepository = typeFlowerRepository;
    }

    public List<TypeFlower> getAllTypeFlowerBaseDate(){
        return typeFlowerRepository.findAll();
    }


    @Transactional
    public void saveBaseDateTypeFlower(NewTypeFlowerDTO dto) {
        TypeFlower typeFlower = new TypeFlower(null, dto.getType(), dto.getDescription());
        typeFlowerRepository.save(typeFlower);
    }


    @Transactional
    public void  deleteType(Long id){
        typeFlowerRepository.deleteById(id);
    }

    public TypeFlower findType(String title){
        log.info(title);
        return typeFlowerRepository.findByTypeName(title).orElseThrow(() -> new NoSuchElementException());
    }
}
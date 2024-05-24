package com.example.businesslogic.serivce.flower.individual_flower;

import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.Flower;

import com.example.businesslogic.repository.FlowerRepository;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Validated
public class FlowerService implements FlowerServiceImpl {


    private final FlowerRepository flowerRepository;

    private final TypeFlowerService typeFlowerService;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository, TypeFlowerService typeFlowerService) {
        this.flowerRepository = flowerRepository;
        this.typeFlowerService = typeFlowerService;
    }

    @Override
    public List<Flower> allFlowers() {
        return flowerRepository.findAll();
    }

    @Override
    public Optional<Flower> findFlower(Long id) {
        return flowerRepository.findById(id);
    }



    @Override
    @Transactional
    public Flower createFlower(NewFlowerDTO payload) {
        try {
            return flowerRepository.save(new Flower(
                    null,
                    payload.getTitle(),
                    payload.getPrice(),
                    payload.getExtraCharge(),
                    payload.getAccountingQuantity(),
                    payload.getActualQuantity(),
                    typeFlowerService.findType(payload.getType())));
        } catch (DataIntegrityViolationException exception){
            throw exception;
        }
    }

    // возможно нужно тоже сделать sql исключения
    @Override
    @Transactional
    public void updateFlower(Long id, UpdateFlowerDTO payload) {
        flowerRepository.findById(id).ifPresentOrElse(
                newDataForflower -> {
                    newDataForflower.setTitle(payload.getTitle());
                    newDataForflower.setPrice(payload.getPrice());
                    newDataForflower.setAccountingQuantity(payload.getAccountingQuantity());
                    newDataForflower.setActualQuantity(payload.getActualQuantity());
                    newDataForflower.setExtraCharge(payload.getExtraCharge());
                }, () -> {
                    throw new NoSuchElementException();
                }
        );
    }

    @Override
    @Transactional
    public void deleteFlower(Long id) {
        flowerRepository.deleteById(id);
    }



}

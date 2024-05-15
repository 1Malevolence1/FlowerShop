package com.example.businesslogic.serivce.flower;

import com.example.businesslogic.dto.NewFlowerDTO;
import com.example.businesslogic.models.Flower;
import com.example.businesslogic.record.flower.UpdateFlowerPayload;
import com.example.businesslogic.repository.FlowerRepository;
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

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
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
                    payload.getActualQuantity()));
        } catch (DataIntegrityViolationException exception){
            throw exception;
        }
    }

    // возможно нужно тоже сделать sql исключения
    @Override
    @Transactional
    public void updateFlower(Long id, UpdateFlowerPayload payload) {
        flowerRepository.findById(id).ifPresentOrElse(
                newDataForflower -> {
                    newDataForflower.setTitle(payload.title());
                    newDataForflower.setPrice(payload.price());
                    newDataForflower.setAccountingQuantity(payload.accountingQuantity());
                    newDataForflower.setActualQuantity(payload.actualQuantity());
                    newDataForflower.setExtraCharge(payload.extraCharge());
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

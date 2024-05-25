package com.example.businesslogic.serivce.flower.individual_flower;

import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.flower.Flower;

import com.example.businesslogic.repository.FlowerRepository;
import com.example.businesslogic.repository.FlowerServiceImpl;
import com.example.businesslogic.models.flower.inventory.Inventory;
import com.example.businesslogic.repository.InventoryRepository;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class FlowerService implements FlowerServiceImpl {


    private final FlowerRepository flowerRepository;

    private final TypeFlowerService typeFlowerService;

    private final InventoryRepository inventoryRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository, TypeFlowerService typeFlowerService, InventoryRepository inventoryRepository) {
        this.flowerRepository = flowerRepository;
        this.typeFlowerService = typeFlowerService;
        this.inventoryRepository = inventoryRepository;
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
        return saveBaseDataFlower(payload);
    }

    // возможно нужно тоже сделать sql исключения
    @Override
    @Transactional
    public void updateFlower(Long id, UpdateFlowerDTO payload) {
        flowerRepository.findById(id).ifPresentOrElse(
                newDataForflower -> {
                    newDataForflower.setTitle(payload.getTitle());
                    newDataForflower.setPrice(payload.getPrice());
                    newDataForflower.getInventory().setActualQuantity(payload.getActualQuantity());
                    newDataForflower.getInventory().setAccountingQuantity(payload.getAccountingQuantity());
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

    private void saveBaseDataInventory(Flower flower, NewFlowerDTO payload){
        Inventory inventory =   new Inventory( flower, payload.getAccountingQuantity(), payload.getActualQuantity());
        inventoryRepository.save(inventory);
    }


    private Flower saveBaseDataFlower(NewFlowerDTO payload){
        try {
            Flower flower = flowerRepository.save(new Flower(
                    null,
                    payload.getTitle(),
                    payload.getPrice(),
                    payload.getExtraCharge(),
                    null,
                    typeFlowerService.findType(payload.getType())));

            saveBaseDataInventory(flower, payload);
            log.info("{}", flower);
            return flower;

        } catch (DataIntegrityViolationException exception){
            throw exception;
        }
    }
}



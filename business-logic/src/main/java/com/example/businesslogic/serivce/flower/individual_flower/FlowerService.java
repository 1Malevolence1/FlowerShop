package com.example.businesslogic.serivce.flower.individual_flower;

import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.FlowerRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import com.example.businesslogic.serivce.flower.supply_flower.inventory.InventoryService;
import com.example.businesslogic.serivce.flower.supplier.SupplierService;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class FlowerService extends AbstractManagerBaseDate<NewFlowerDTO, UpdateFlowerDTO, Flower> {


    private final FlowerRepository flowerRepository;

    private final TypeFlowerService typeFlowerService;

    private final InventoryService inventoryService;

    private final SupplierService supplierService;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository, TypeFlowerService typeFlowerService, InventoryService inventoryService, SupplierService supplierService) {
        super(flowerRepository);
        this.flowerRepository = flowerRepository;
        this.typeFlowerService = typeFlowerService;
        this.inventoryService = inventoryService;
        this.supplierService = supplierService;
    }


    @Override
    public Flower saveEntityReturnObject(NewFlowerDTO payload) {
            log.info("{}", payload);
            Supplier supplier = supplierService.findByName(payload.getSupplierName());
            log.info("{}", supplier);
            Flower flower = flowerRepository.save(new Flower(
                    null,
                    payload.getTitle(),
                    payload.getPrice(),
                    payload.getExtraCharge(),
                    null,
                    typeFlowerService.findByName(payload.getType()),
                    supplier));

            inventoryService.saveBaseDataInventory(flower, payload);

            log.info("{}", flower);
            return flower;
    }

    // возможно нужно тоже сделать sql исключения
    @Override
    public void updateEntity(UpdateFlowerDTO payload, Long id) {
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

}



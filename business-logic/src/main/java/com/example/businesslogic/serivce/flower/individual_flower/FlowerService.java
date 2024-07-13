package com.example.businesslogic.serivce.flower.individual_flower;

import com.example.businesslogic.dto.flowers.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.flowers.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.models.flower.inventory.Inventory;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.FlowerRepository;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import com.example.businesslogic.serivce.flower.individual_flower.inventory.InventoryService;
import com.example.businesslogic.serivce.flower.supplier.SupplierService;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class FlowerService extends AbstractManagerBaseDate<NewFlowerDTO, UpdateFlowerDTO, Flower> {
    private final FlowerRepository flowerRepository;
    private final TypeFlowerService typeFlowerService;
    private final SupplierService supplierService;
    private final InventoryService inventoryService;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository, TypeFlowerService typeFlowerService, SupplierService supplierService, InventoryService inventoryService) {
        super(flowerRepository);
        this.flowerRepository = flowerRepository;
        this.typeFlowerService = typeFlowerService;
        this.supplierService = supplierService;
        this.inventoryService = inventoryService;
    }


    @Override
    public Flower saveEntityReturnObject(NewFlowerDTO payload) {
        Supplier supplier = supplierService.findByName(payload.getSupplierName());
        TypeFlower typeFlower = typeFlowerService.findByName(payload.getType());
        Inventory inventory = null;

        if (payload.getInventory() != null) {
             inventory = inventoryService.build(payload.getInventory());
        }

        Flower flower = flowerRepository.save(new Flower(
                null,
                payload.getTitle(),
                payload.getPrice(),
                payload.getExtraCharge(),
                inventory,
                typeFlower,
                supplier));


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



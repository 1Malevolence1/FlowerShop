package com.example.managerapp.client;


import com.example.managerapp.record.flower.Flower;
import com.example.managerapp.record.flower.NewFlowerPayload;
import com.example.managerapp.record.flower.UpdateFlowerPayload;

import java.util.List;
import java.util.Optional;

public interface FlowerClientServiceImpl {


    List<Flower> allFlowers();

    Optional<Flower> findFlower(Long id);

    Flower createFlower(String title, Integer price, Integer extraCharge, Integer accountingQuantity, Integer actualQuantity);

    void updateFlower(Long id, UpdateFlowerPayload payload);

    void deleteFlower(Long id);

}

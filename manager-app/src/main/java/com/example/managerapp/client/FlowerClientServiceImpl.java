package com.example.managerapp.client;

import com.example.managerapp.flower.Flower;
import com.example.managerapp.flower.NewFlowerPayload;
import com.example.managerapp.flower.UpdateFlowerPayload;

import java.util.List;
import java.util.Optional;

public interface FlowerClientServiceImpl {


    List<Flower> allFlowers();

    Optional<Flower> findFlower(Long id);

    Flower createFlower(NewFlowerPayload newFlowerPayload);

    void updateFlower(Long id, UpdateFlowerPayload payload);

    void deleteFlower(Long id);

}

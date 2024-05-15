package com.example.managerapp.client;


import com.example.managerapp.DTO.NewFlowerDTO;
import com.example.managerapp.DTO.UpdateFlowerDTO;
import com.example.managerapp.record.flower.Flower;
import com.example.managerapp.record.flower.UpdateFlowerPayload;

import java.util.List;
import java.util.Optional;

public interface FlowerClientServiceImpl {


    List<Flower> allFlowers();

    Optional<Flower> findFlower(Long id);

    Flower createFlower(NewFlowerDTO payload);

    void updateFlower(Long id, UpdateFlowerDTO payload);

    void deleteFlower(Long id);

}

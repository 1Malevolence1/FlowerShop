package com.example.managerapp.client;


import com.example.managerapp.dto.flower.CountAllFlower;
import com.example.managerapp.dto.flower.individual_flower.NewFlowerDTO;
import com.example.managerapp.dto.flower.individual_flower.UpdateFlowerDTO;
import com.example.managerapp.dto.flower.individual_flower.Flower;

import java.util.List;
import java.util.Optional;

public interface FlowerClientServiceImpl {


    List<Flower> allFlowers();

    Optional<Flower> findFlower(Long id);

    Flower createFlower(NewFlowerDTO payload);

    void updateFlower(Long id, UpdateFlowerDTO payload);

    void deleteFlower(Long id);

    CountAllFlower countFlower();

}

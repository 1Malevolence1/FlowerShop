package com.example.businesslogic.serivce.flower;


import com.example.businesslogic.models.Flower;
import com.example.businesslogic.record.flower.NewFlowerPayload;

import java.util.List;
import java.util.Optional;

public interface FlowerServiceImpl {

    List<Flower> allFlowers();

    Optional<Flower> findFlower(Long id);

    Flower createFlower(NewFlowerPayload newFlowerPayload);

    void deleteFlower(Long id);

}

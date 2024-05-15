package com.example.businesslogic.serivce.flower;


import com.example.businesslogic.dto.NewFlowerDTO;
import com.example.businesslogic.models.Flower;
import com.example.businesslogic.record.flower.UpdateFlowerPayload;

import java.util.List;
import java.util.Optional;

public interface FlowerServiceImpl {

    List<Flower> allFlowers();

    Optional<Flower> findFlower(Long id);

    Flower createFlower(NewFlowerDTO newFlowerDTO);

    void updateFlower(Long id, UpdateFlowerPayload payload);

    void deleteFlower(Long id);

}

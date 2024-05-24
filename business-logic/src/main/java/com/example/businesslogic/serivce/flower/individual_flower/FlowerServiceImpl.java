package com.example.businesslogic.serivce.flower.individual_flower;


import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.Flower;


import java.util.List;
import java.util.Optional;

public interface FlowerServiceImpl {

    List<Flower> allFlowers();

    Optional<Flower> findFlower(Long id);

    Flower createFlower(NewFlowerDTO newFlowerDTO);

    void updateFlower(Long id, UpdateFlowerDTO payload);

    void deleteFlower(Long id);

}

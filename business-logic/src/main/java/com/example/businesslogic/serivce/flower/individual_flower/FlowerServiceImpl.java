package com.example.businesslogic.serivce.flower.individual_flower;


import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.flower.Flower;


import java.util.List;
import java.util.Optional;

public interface FlowerServiceImpl {

    List<Flower> findAllEntityFormBaseDate();

    Optional<Flower> find(Long id);

    Flower saveEntityFromBaseDateReturnObject(NewFlowerDTO newFlowerDTO);

    void updateEntityFromBaseDate(Long id, UpdateFlowerDTO payload);

    void deleteEntityFromBaseDateById(Long id);

}

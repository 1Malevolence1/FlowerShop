package com.example.businesslogic.controler.flower.individual_flower;


import com.example.businesslogic.controler.flower.ControllerHelper;
import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class FlowerRestControllerHelper extends ControllerHelper<NewFlowerDTO, UpdateFlowerDTO, Flower> {

    @Autowired
    public FlowerRestControllerHelper(FlowerService service) {
        super(service);
    }
}

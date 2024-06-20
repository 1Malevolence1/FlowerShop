package com.example.businesslogic.controler.flower.individual_flower;


import com.example.businesslogic.controler.flower.AbstractControllerHelper;
import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlowerRestAbstractControllerHelper extends AbstractControllerHelper<NewFlowerDTO, UpdateFlowerDTO, Flower> {

    @Autowired
    public FlowerRestAbstractControllerHelper(FlowerService service) {
        super(service);
    }
}

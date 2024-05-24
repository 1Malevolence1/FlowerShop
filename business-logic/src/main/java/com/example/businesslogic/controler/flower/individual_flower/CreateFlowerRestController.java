package com.example.businesslogic.controler.flower.individual_flower;


import com.example.businesslogic.dto.individual_flower.NewFlowerDTO;
import com.example.businesslogic.models.Flower;
import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("main/flowers/create")
@Slf4j

public class CreateFlowerRestController {

    private final FlowerService flowerService;

    @Autowired
    public CreateFlowerRestController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }


    @PostMapping
    public ResponseEntity<?> createFlower(@Valid @RequestBody NewFlowerDTO payload, BindingResult bindingResult,
                                          UriComponentsBuilder uriComponentsBuilder) throws BindException {

        if(bindingResult.hasErrors()){
            if(bindingResult instanceof BindException exception){
                throw exception;
            } else
                throw new BindException(bindingResult);
        }
            Flower newFlower = flowerService.createFlower(payload);
              log.info("Созадн новый цвето {}", newFlower);
              return ResponseEntity.created(uriComponentsBuilder.replacePath("/main/flower/{flowerId}/flower_info").build(Map.of("flowerId", newFlower.getId()))).body(newFlower);

    }



}

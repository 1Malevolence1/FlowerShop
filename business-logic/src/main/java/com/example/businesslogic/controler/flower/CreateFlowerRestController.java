package com.example.businesslogic.controler.flower;


import com.example.businesslogic.models.Flower;
import com.example.businesslogic.record.flower.NewFlowerPayload;
import com.example.businesslogic.serivce.flower.FlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
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
    public ResponseEntity<?> createFlower(@Valid @RequestBody NewFlowerPayload payload,
                                          BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) throws BindException {

        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException bindException) {
                throw bindException;
            } else {
                throw new BindException(bindingResult);
            }
        }
        Flower newFlower = flowerService.createFlower(payload);
        log.info("Добавлен цветок: {}", newFlower);
        return ResponseEntity.created(
                uriComponentsBuilder.replacePath("main/flowers/{flowerId}").build(Map.of("flowerId", newFlower.getId()))).body(newFlower);
    }
}

package com.example.businesslogic.controler.flower.individual_flower;


import com.example.businesslogic.dto.flowers.individual_flower.NewFlowerDTO;
import com.example.businesslogic.models.flower.Flower;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("main/flowers/create")
@Slf4j
@RequiredArgsConstructor
public class CreateFlowerRestController {

    private final FlowerControllerHelper controllerHelper;

    @PostMapping
    public ResponseEntity<?> createFlower(@Valid @RequestBody NewFlowerDTO payload, BindingResult bindingResult,
                                          UriComponentsBuilder uriComponentsBuilder) throws BindException {

        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else
                throw new BindException(bindingResult);
        }
        log.info("{}", payload);
        Flower flower = controllerHelper.checkSaveEntityBaseDateReturnObject(payload);
        log.info("Созадн новый цвето {}", flower);
        return ResponseEntity.created(uriComponentsBuilder.replacePath("/main/flower/{flowerId}/flower_info").build(Map.of("flowerId", flower.getId()))).body(flower);

    }
}

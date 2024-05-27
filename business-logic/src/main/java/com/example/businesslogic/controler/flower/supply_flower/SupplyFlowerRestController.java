package com.example.businesslogic.controler.flower.supply_flower;


import com.example.businesslogic.dto.supply_flower.AddFlowerSupplyDTO;
import com.example.businesslogic.serivce.flower.supply_flower.SupplyFlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("main/supply_flower")
@Slf4j
public class SupplyFlowerRestController {

    private final SupplyFlowerService supplyFlowerService;


    @Autowired
    public SupplyFlowerRestController(SupplyFlowerService supplyFlowerService) {
        this.supplyFlowerService = supplyFlowerService;
    }

    @PatchMapping("sum")
    public ResponseEntity<Void> sumFlowerSupply(@RequestBody AddFlowerSupplyDTO dto){
        log.info("Начался метод по добавлению цветов");
        supplyFlowerService.sumFlower(dto);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("deduct")
    public ResponseEntity<Void> deductFlowerSupply(@RequestBody AddFlowerSupplyDTO dto){
        log.info("Начался метод по отниманию цветов");
        supplyFlowerService.deductFlower(dto);
        return ResponseEntity.noContent().build();
    }
}

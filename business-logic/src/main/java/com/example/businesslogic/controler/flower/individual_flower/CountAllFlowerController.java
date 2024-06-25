package com.example.businesslogic.controler.flower.individual_flower;

import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("flower/count")
public class CountAllFlowerController {

    private final FlowerService flowerService;
    @Autowired
    public CountAllFlowerController(FlowerService flowerService ) {
        this.flowerService = flowerService;
    }


    @GetMapping()
    public CountAllFlower getAllCountFlower() {
        return flowerService.findCountAll();
    }
}

package com.example.businesslogic.controler.flower.individual_flower;

import com.example.businesslogic.models.flower.Flower;
import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("main/flowers/list")
public class FlowersListRestController {

    private final FlowerService flowerService;

    @Autowired
    public FlowersListRestController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getAllFlowers(){
        return flowerService.findAllEntityFormBaseDate();
    }
}

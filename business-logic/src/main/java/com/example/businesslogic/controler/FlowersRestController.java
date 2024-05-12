package com.example.businesslogic.controler;

import com.example.businesslogic.models.Flower;
import com.example.businesslogic.serivce.flower.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("main/flowers/list")
public class FlowersRestController {

    private final FlowerService flowerService;

    @Autowired
    public FlowersRestController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getAllFlowers(){
        return flowerService.allFlowers();
    }
}

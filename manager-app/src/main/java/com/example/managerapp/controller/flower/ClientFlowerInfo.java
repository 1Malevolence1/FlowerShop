package com.example.managerapp.controller.flower;


import com.example.managerapp.client.FlowerClientService;
import com.example.managerapp.record.flower.Flower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("main/flower/{flowerId:\\d+}/info")
@Slf4j
public class ClientFlowerInfo {

    private final FlowerClientService flowerClientService;


    @Autowired
    public ClientFlowerInfo(FlowerClientService flowerClientService) {
        this.flowerClientService = flowerClientService;
    }
    @ModelAttribute("flower")
    public Flower getFlower(@PathVariable("flowerId") Long id)   {
        return flowerClientService.findFlower(id).orElseThrow(() -> new NoSuchElementException());
    }


    @GetMapping()
    public String getFlowerInfoPage(){
        return "main/flowers/flower_info";
    }
}

package com.example.managerapp.controller.flower.individual_flower;

import com.example.managerapp.client.flower.individual_flower.FlowerRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/flowers/list")
public class ClientListFlower {

    private final FlowerRestClientService flowerRestClientService;

    @Autowired
    public ClientListFlower(FlowerRestClientService flowerRestClientService) {
        this.flowerRestClientService = flowerRestClientService;
    }


    @GetMapping()
    public String getPageListFlowers(Model model){
        model.addAttribute("flowers", flowerRestClientService.allFlowers());
        return "main/flowers/flowers_list";
    }
}

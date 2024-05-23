package com.example.managerapp.controller.flower;

import com.example.managerapp.client.FlowerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/flowers/list")
public class ClientListFlower {

    private final FlowerClientService flowerClientService;

    @Autowired
    public ClientListFlower(FlowerClientService flowerClientService) {
        this.flowerClientService = flowerClientService;
    }


    @GetMapping()
    public String getPageListFlowers(Model model){
        model.addAttribute("flowers", flowerClientService.allFlowers());
        return "main/flowers/flowers_list";
    }
}

package com.example.managerapp.controller.flower;

import com.example.managerapp.DTO.NewFlowerDTO;
import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.FlowerClientService;
import com.example.managerapp.DTO.Flower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("main/flowers/create")
@Slf4j
public class ClientCreateFlower {

    private final FlowerClientService flowerClientService;

    @Autowired
    public ClientCreateFlower(FlowerClientService flowerClientService) {
        this.flowerClientService = flowerClientService;
    }



    @GetMapping()
    public String getPageCrateFlower(){
        return "main/flowers/flower_create";
    }
    @PostMapping()
    public String createFlower(NewFlowerDTO payload, Model model){
        try {
          Flower newFlower = flowerClientService.createFlower(payload);
            log.info("Добавлен новый цветок: {}", payload);
            return "redirect:/main/flower/%d/info".formatted(newFlower.id());

        } catch (BadRequestException exception){
                model.addAttribute("payload", payload);
                model.addAttribute("errors", exception.getErrors());
                log.info("{}", exception.getErrors());
                return "main/flowers/flower_create";

        }
    }

}
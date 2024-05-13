package com.example.managerapp.controller.flower;

import com.example.managerapp.client.FlowerClientService;
import com.example.managerapp.exeption.BadRequestException;
import com.example.managerapp.record.flower.NewFlowerPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;

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
    public String createFlower(NewFlowerPayload payload, Model model){
        try {
            flowerClientService.createFlower(
                    payload.title(),
                    payload.price(),
                    payload.extraCharge(),
                    payload.accountingQuantity(),
                    payload.accountingQuantity());
            log.info("Добавлен новый цветок: {}", payload);
            return "redirect:/main/flowers/list";
        } catch (BadRequestException exception){
            {
                model.addAttribute("payload", payload);
                model.addAttribute("errors", exception.getErrors());
                log.info("{}", exception.getErrors());
                return "redirect:/main/flowers/flower_create";
            }
        }
    }

}

package com.example.managerapp.controller.supply_flower;

import com.example.managerapp.DTO.supply_flower.AddFlowerSupplyDTO;
import com.example.managerapp.client.FlowerClientService;
import com.example.managerapp.client.SupplyFlowerRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main/supply-flowers")
@Slf4j
public class SupplyFlowerController {

    private final FlowerClientService flowerClientService;
    private final SupplyFlowerRestClient supplyFlowerRestClient;

    @Autowired
    public SupplyFlowerController(FlowerClientService flowerClientService, SupplyFlowerRestClient supplyFlowerRestClient) {
        this.flowerClientService = flowerClientService;
        this.supplyFlowerRestClient = supplyFlowerRestClient;
    }

    @GetMapping()
    public String getSupplyFlowerPage(Model model){
        model.addAttribute("flowers", flowerClientService.allFlowers());
        return "main/supply-flowers/supply_flowers_page";
    }


    @PostMapping("sum")
    public String sumFlowerSupply(@RequestParam("flowerId") Long id, @RequestParam("addedQuantity") Integer addedQuantity){
            log.info("Метод по добавлению начался");
            supplyFlowerRestClient.sumFlowerSupply(id, addedQuantity);
            log.info("Изменения в id: {}, изменилось на {}", id, addedQuantity);
            return "redirect:/main/supply-flowers";
        }


    @PostMapping("deduct")
    public String deductFlowerSupply(@RequestParam("flowerId") Long id, @RequestParam("addedQuantity") Integer addedQuantity){
        log.info("Метод по отниманию начался");
        supplyFlowerRestClient.deductFlowerSupply(id, addedQuantity);
        log.info("Изменения в id: {}, изменилось на {}", id, addedQuantity);
        return "redirect:/main/supply-flowers";
    }
    }

package com.example.managerapp.controller.flower.supply_flower;

import com.example.managerapp.client.flower.individual_flower.FlowerRestClientService;
import com.example.managerapp.client.flower.supply_flower.SupplyFlowerRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main/supply-flowers")
@Slf4j
public class SupplyFlowerController {

    private final FlowerRestClientService flowerRestClientService;
    private final SupplyFlowerRestClient supplyFlowerRestClient;

    @Autowired
    public SupplyFlowerController(FlowerRestClientService flowerRestClientService, SupplyFlowerRestClient supplyFlowerRestClient) {
        this.flowerRestClientService = flowerRestClientService;
        this.supplyFlowerRestClient = supplyFlowerRestClient;
    }

    @GetMapping("sum")
    public String getSumSupplyFlowerPage(Model model){
        model.addAttribute("flowers", flowerRestClientService.allFlowers());
        return "main/supply-flowers/supply_sum_flowers_page";
    }

    @GetMapping("deduct")
    public String getDeductSupplyFlowerPage(Model model){
        model.addAttribute("flowers", flowerRestClientService.allFlowers());
        return "main/supply-flowers/supply_deduct_flowers_page";
    }


    @PostMapping("sum")
    public String sumFlowerSupply(@RequestParam("flowerId") Long id, @RequestParam("addedQuantity") Integer addedQuantity){
            log.info("Метод по добавлению начался");
            supplyFlowerRestClient.sumFlowerSupply(id, addedQuantity);
            log.info("Изменения в id: {}, изменилось на {}", id, addedQuantity);
            return "redirect:/main/supply-flowers/sum";
        }


    @PostMapping("deduct")
    public String deductFlowerSupply(@RequestParam("flowerId") Long id, @RequestParam("addedQuantity") Integer addedQuantity){
        log.info("Метод по отниманию начался");
        supplyFlowerRestClient.deductFlowerSupply(id, addedQuantity);
        log.info("Изменения в id: {}, изменилось на {}", id, addedQuantity);
        return "redirect:/main/supply-flowers/deduct";
    }
    }

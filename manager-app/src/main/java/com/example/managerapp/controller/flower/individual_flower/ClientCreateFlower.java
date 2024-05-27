package com.example.managerapp.controller.flower.individual_flower;

import com.example.managerapp.client.flower.supplier.SupplierRestClientService;
import com.example.managerapp.client.flower.type_flower.TypeFlowerClientService;
import com.example.managerapp.dto.flower.individual_flower.NewFlowerDTO;
import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.flower.individual_flower.FlowerRestClientService;
import com.example.managerapp.dto.flower.individual_flower.Flower;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ClientCreateFlower {

    private final FlowerRestClientService flowerRestClientService;
    private final TypeFlowerClientService typeFlowerClientService;

    private final SupplierRestClientService supplierRestClientService;



    @GetMapping()
    public String getPageCrateFlower(Model model){
        model.addAttribute("typeFlowers", typeFlowerClientService.showTypeFlower());
        model.addAttribute("suppliers", supplierRestClientService.findAll());
        return "main/flowers/flower_create";
    }
    @PostMapping()
    public String createFlower(NewFlowerDTO payload, Model model){
        try {
            log.info("{}", payload);
          Flower newFlower = flowerRestClientService.createFlower(payload);
            log.info("Добавлен новый цветок: {}", payload);
            return "redirect:/main/flower/%d/info".formatted(newFlower.getId());

        } catch (BadRequestException exception){
                model.addAttribute("payload", payload);
                model.addAttribute("errors", exception.getErrors());
                log.info("{}", exception.getErrors());
                return "main/flowers/flower_create";

        }
    }

}

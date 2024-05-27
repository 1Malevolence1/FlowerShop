package com.example.managerapp.controller.flower.individual_flower;

import com.example.managerapp.dto.flower.individual_flower.Flower;
import com.example.managerapp.dto.flower.individual_flower.UpdateFlowerDTO;
import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.flower.individual_flower.FlowerRestClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("main/flower/{flowerId:\\d+}")
@Slf4j
public class ClientManagerFlower {

    private final FlowerRestClientService flowerRestClientService;

    @Autowired
    public ClientManagerFlower(FlowerRestClientService flowerRestClientService) {
        this.flowerRestClientService = flowerRestClientService;
    }

    @ModelAttribute("flower")
    public Flower getFlower(@PathVariable("flowerId") Long id)   {
        return flowerRestClientService.findFlower(id).orElseThrow(() -> new NoSuchElementException());
    }

    @GetMapping("update")
    public String getPageUpdateFlower(){
        return "main/flowers/flower_update";
    }

    @PostMapping("update")
    public String updateDataFlower(@ModelAttribute(name = "flower", binding = false) Flower flower,
                                   UpdateFlowerDTO updateFlowerDTO,
                                   Model model){
        try {

            flowerRestClientService.updateFlower(flower.getId(),updateFlowerDTO);
            log.info("Обновлён цветок с айди {}", flower.getId());
            return "redirect:/main/flower/%d/info".formatted(flower.getId());

        } catch (BadRequestException badRequestException){
            model.addAttribute("payload", updateFlowerDTO);
            model.addAttribute("errors", badRequestException.getErrors());
            return "main/flowers/flower_update";
        }
    }


    @PostMapping("delete")
    public String deleteFlower(@PathVariable("flowerId") Long id){
        flowerRestClientService.deleteFlower(id);
        return "redirect:/main/flowers/list";
    }
}

package com.example.managerapp.controller.flower;

import com.example.managerapp.DTO.UpdateFlowerDTO;
import com.example.managerapp.client.FlowerClientService;
import com.example.managerapp.exeption.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/flower/{flowerId:\\d+}")
@Slf4j
public class ClientManagerFlower {

    private final FlowerClientService flowerClientService;

    @Autowired
    public ClientManagerFlower(FlowerClientService flowerClientService) {
        this.flowerClientService = flowerClientService;
    }


    @PostMapping("update")
    public String updateDataFlower(@PathVariable("flowerId") Long id,
                                   UpdateFlowerDTO updateFlowerDTO,
                                   Model model){
        try {
            flowerClientService.updateFlower(id,updateFlowerDTO);
            log.info("Обновлён цветок с айди {}", id);
            return "main/flower/flower_info";

        } catch (BadRequestException badRequestException){
            model.addAttribute("payload", updateFlowerDTO);
            model.addAttribute("errors", badRequestException.getErrors());
            return "redirect:/main/flower/flower_update";
        }
    }


    @PostMapping("delete")
    public String deleteFlower(@PathVariable("flowerId") Long id){
        flowerClientService.deleteFlower(id);
        return "redirect:/main/flowers/list";
    }
}

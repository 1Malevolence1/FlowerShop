package com.example.managerapp.controller.flower.type_flower;


import com.example.managerapp.client.flower.individual_flower.FlowerClientService;
import com.example.managerapp.client.flower.type_flower.TypeFlowerClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/type_flower")
@Slf4j
public class TypeFlowerController {

    private final TypeFlowerClientService typeFlowerClientService;

    @Autowired
    public TypeFlowerController(TypeFlowerClientService typeFlowerClientService) {
        this.typeFlowerClientService = typeFlowerClientService;
    }

    @GetMapping()
    public String getPageListFlowers(Model model){
        model.addAttribute("flowers", typeFlowerClientService.allFlowers());
        return "main/flowers/flowers_list";
    }

}

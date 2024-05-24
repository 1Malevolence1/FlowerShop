package com.example.managerapp.controller.flower.type_flower;


import com.example.managerapp.client.flower.type_flower.TypeFlowerClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/type_flower/list")
@Slf4j
public class TypeFlowerListController {

    private final TypeFlowerClientService typeFlowerClientService;

    @Autowired
    public TypeFlowerListController(TypeFlowerClientService typeFlowerClientService) {
        this.typeFlowerClientService = typeFlowerClientService;
    }

    @GetMapping()
    public String getPageListFlowers(Model model){
        model.addAttribute("type_flowers", typeFlowerClientService.allTypeFlower());
        return "main/type_flower/type_flower_list_page";
    }

}

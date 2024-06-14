package com.example.managerapp.controller.flower.type_flower;

import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.flower.type_flower.TypeFlowerClientService;
import com.example.managerapp.dto.flower.type_flower.NewTypeFlowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/type_flower/create")
public class TypeFlowerCreate {

    private final TypeFlowerClientService typeFlowerClientService;

    @Autowired
    public TypeFlowerCreate(TypeFlowerClientService typeFlowerClientService) {
        this.typeFlowerClientService = typeFlowerClientService;
    }


    @GetMapping()
    public String getTypeFlowerPage(){
        return "main/type_flower/type_flower_create_page";
    }

    @PostMapping()
    public String getTypeFlowerPage(NewTypeFlowerDTO dto, Model model){
       try {
           typeFlowerClientService.crateType(dto);
           return "redirect:/main/type_flower/list";
       }
       catch (BadRequestException exception){
           model.addAttribute("errors", exception.getErrors());
           return "main/type_flower/type_flower_create_page";
       }

    }
}

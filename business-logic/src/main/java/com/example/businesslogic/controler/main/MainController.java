package com.example.businesslogic.controler.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainController {

    @GetMapping()
    public String getMainPage(){
        return "main_page";
    }
}

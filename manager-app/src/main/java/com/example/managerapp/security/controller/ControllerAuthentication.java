package com.example.managerapp.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class ControllerAuthentication {


    @GetMapping("login")
    public String getPageAuthentication(@RequestParam(value = "error", required = false) String error, Model model){
        if (error != null) {
            model.addAttribute("errorMessage", "Неправильный логин или пароль");
        }
        model.addAttribute("error", error != null);
        return "main/security/custom_login";
    }
}

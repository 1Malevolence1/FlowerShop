package com.example.managerapp.security.controller;

import com.example.clientapp.security.dto.DtoMyUser;
import com.example.clientapp.security.exeption.UsernameFoundInBaseDate;
import com.example.clientapp.security.service.MyUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registration")
@Slf4j
@RequiredArgsConstructor
public class ControllerRegistration {

    private final MyUserService myUserService;


    @GetMapping
    public String getRegistrationPage(){
        return "true_login";
    }

    @PostMapping
    public String registrationNewUser(DtoMyUser dto, Model model){
        try {
            myUserService.save(dto);
            return "redirect:/true_autorisaishen";
        } catch (UsernameFoundInBaseDate usernameFoundInBaseDate){
            model.addAttribute("error", usernameFoundInBaseDate.getError());
            return "true_login";
        }
    }
}

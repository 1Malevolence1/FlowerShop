package com.example.managerapp.security.controller;


import com.example.managerapp.security.dto.DtoMyUser;
import com.example.managerapp.security.exeption.UsernameFoundInBaseDate;
import com.example.managerapp.security.service.MyUserService;
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
        return "main/security/registration";
    }

    @PostMapping
    public String registrationNewUser(DtoMyUser dto, Model model){
        try {
            myUserService.save(dto);
            return "redirect:main/security/custom_login";
        } catch (UsernameFoundInBaseDate usernameFoundInBaseDate){
            model.addAttribute("error", usernameFoundInBaseDate.getError());
            return "main/security/registration";
        }
    }
}

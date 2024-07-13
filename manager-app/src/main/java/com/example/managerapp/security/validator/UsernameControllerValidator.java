package com.example.managerapp.security.validator;/*
package com.example.clientapp.security.validator;


import com.example.clientapp.security.dto.DtoMyUser;
import com.example.clientapp.security.exeption.UsernameFoundInBaseDate;
import com.example.clientapp.security.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsernameControllerValidator {

    private final MyUserService service;

    public boolean crateNewUser(DtoMyUser dto){

           if(checkUsernameInBaseDate(dto.getUsername())){
               service.buildMyUser(dto);
               return true;
           } else return false;
    }


    private void checkUsernameInBaseDate(String username){
        if(service.findByUser(username) != null){
            throw new UsernameFoundInBaseDate("Данный логин зантя. Придумкайте дургой лоигни");
        }

        return true;
    }
}
*/

package com.example.businesslogic.serivce.flower;

import org.springframework.stereotype.Component;

@Component
public class ConvertingNumbers {


    public Integer convertingNumbersFromAString(String string){
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw e;
        }
    }



}

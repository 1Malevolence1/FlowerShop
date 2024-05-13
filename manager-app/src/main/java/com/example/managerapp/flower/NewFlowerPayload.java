package com.example.managerapp.flower;

import javax.validation.constraints.NotBlank;

public record NewFlowerPayload(

        @NotBlank(message = "Название не должно быть пустым")
        String title,
        Double price,
        Double extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity

) {

}


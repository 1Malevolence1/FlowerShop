package com.example.businesslogic.record.flower;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record NewFlowerPayload(


        @NotBlank
        String title,

        @PositiveOrZero
        int price,

        @PositiveOrZero
        int extraCharge,

        @PositiveOrZero
        int accountingQuantity,

        @PositiveOrZero
        int actualQuantity

) {


}


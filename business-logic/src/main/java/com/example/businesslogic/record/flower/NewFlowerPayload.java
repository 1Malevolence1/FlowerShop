package com.example.businesslogic.record.flower;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;

public record NewFlowerPayload(

        @NotBlank(message = "Название не должно быть пустым")
        String title,

        @NotNull
        Integer price,

        @NotNull
        Integer extraCharge,
        @NotNull
        Integer accountingQuantity,

        @NotNull
        Integer actualQuantity

) {

}


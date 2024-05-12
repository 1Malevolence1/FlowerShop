package com.example.businesslogic.record.flower;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record NewFlowerPayload(


        Long id,

        @NotBlank(message = "Название не должно быть пустым")
        String title,

        BigDecimal price,
        BigDecimal extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity

) {

}


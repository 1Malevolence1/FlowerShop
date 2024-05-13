package com.example.businesslogic.record.flower;

import javax.validation.constraints.NotBlank;

public record UpdateFlowerPayload(

        @NotBlank(message = "Название не должно быть пустым")
        String title,
        Integer price,
        Integer extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity

) {
}

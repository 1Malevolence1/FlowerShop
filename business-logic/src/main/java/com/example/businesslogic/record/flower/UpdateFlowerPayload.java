package com.example.businesslogic.record.flower;



public record UpdateFlowerPayload(


        String title,
        Integer price,
        Integer extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity

) {
}

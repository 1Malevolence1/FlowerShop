package com.example.businesslogic.record.flower;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record NewFlowerPayload(


        Long id,
        String title,
        Double price,
        Double extraCharge,
        Double accountingQuantity,
        Double actualQuantity

) {

}


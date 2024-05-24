package com.example.managerapp.dto.flower.individual_flower;

import com.example.managerapp.dto.flower.type_flower.TypeFlower;

public record Flower(
        Long id,
        String title,
        Integer price,
        Integer extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity,

        TypeFlower typeFlower
        ) {
}

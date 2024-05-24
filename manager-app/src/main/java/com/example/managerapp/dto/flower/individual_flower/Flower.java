package com.example.managerapp.dto.flower.individual_flower;

public record Flower(
        Long id,
        String title,
        Integer price,
        Integer extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity
        ) {
}

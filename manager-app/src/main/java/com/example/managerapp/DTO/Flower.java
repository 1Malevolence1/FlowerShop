package com.example.managerapp.DTO;

public record Flower(
        Long id,
        String title,
        Integer price,
        Integer extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity
        ) {
}

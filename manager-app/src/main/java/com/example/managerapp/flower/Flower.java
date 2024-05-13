package com.example.managerapp.flower;

public record Flower(
        Long id,
        String title,
        Double price,
        Double extraCharge,
        Integer accountingQuantity,
        Integer actualQuantity
        ) {
}

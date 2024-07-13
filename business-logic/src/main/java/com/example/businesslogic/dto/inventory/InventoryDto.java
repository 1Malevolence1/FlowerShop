package com.example.businesslogic.dto.inventory;


import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    @PositiveOrZero(message = "Учётное количество должно быть больше или равно 0")
    private  Integer accountingQuantity;
    @PositiveOrZero(message = "Фактиченское количество должно быть больше или равно 0")
    private  Integer actualQuantity;


}

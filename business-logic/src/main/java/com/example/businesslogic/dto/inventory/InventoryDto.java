package com.example.businesslogic.dto.inventory;


import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryDto {
    @PositiveOrZero(message = "Учётное количество должно быть больше или равно 0")
    private  Integer accountingQuantity;
    @PositiveOrZero(message = "Фактиченское количество должно быть больше или равно 0")
    private  Integer actualQuantity;


    public InventoryDto(Integer accountingQuantity, Integer actualQuantity) {
        this.accountingQuantity = checkObjectOnNullOtherwiseReturnZero(accountingQuantity);
        this.actualQuantity = checkObjectOnNullOtherwiseReturnZero(actualQuantity);
    }

    private Integer checkObjectOnNullOtherwiseReturnZero(Integer object){
        if(object == null) return 0;
        else return object;
    }
}

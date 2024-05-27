package com.example.businesslogic.dto.individual_flower;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateFlowerDTO {


    @NotBlank(message = "название не должно быть пустым")
    private String title;

    @PositiveOrZero(message = "цена должна быть больше или равно 0")
    private  Integer price;
    @PositiveOrZero(message = "наценка должна быть больше или равно 0")
    private  Integer extraCharge;
    @PositiveOrZero(message = "Учётное количество должно быть больше или равно 0")
    private  Integer accountingQuantity;
    @PositiveOrZero(message = "Фактиченское количество должно быть больше или равно 0")
    private  Integer actualQuantity;

    private String supplierName;


    public UpdateFlowerDTO(String title, Integer price, Integer extraCharge, Integer accountingQuantity, Integer actualQuantity, String supplierName) {
        this.title = title;
        this.price = checkObjectOnNullOtherwiseReturnZero(price);
        this.extraCharge = checkObjectOnNullOtherwiseReturnZero(extraCharge);
        this.accountingQuantity = checkObjectOnNullOtherwiseReturnZero(accountingQuantity);;
        this.actualQuantity = checkObjectOnNullOtherwiseReturnZero(actualQuantity);
        this.supplierName = supplierName;
    }

    private Integer checkObjectOnNullOtherwiseReturnZero(Integer object){
            if(object == null) return 0;
            else return object;
    }
}

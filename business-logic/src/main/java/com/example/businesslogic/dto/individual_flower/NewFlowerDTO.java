package com.example.businesslogic.dto.individual_flower;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
public class NewFlowerDTO {


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

    @NotBlank(message = """ 
            поле "Тип" не может быть пустым
            """)
      private String type;


    private String supplierName;

    public NewFlowerDTO(String title, Integer price, Integer extraCharge, Integer accountingQuantity, Integer actualQuantity, String type, String supplierName) {
        this.title = title;
        this.price = checkObjectOnNullOtherwiseReturnZero(price);
        this.extraCharge = checkObjectOnNullOtherwiseReturnZero(extraCharge);
        this.accountingQuantity = checkObjectOnNullOtherwiseReturnZero(accountingQuantity);;
        this.actualQuantity = checkObjectOnNullOtherwiseReturnZero(actualQuantity);
        this.type = type;
        this.supplierName = supplierName;
    }

    private Integer checkObjectOnNullOtherwiseReturnZero(Integer object){
        if(object == null) return 0;
        else return object;
    }
}


package com.example.businesslogic.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
public class NewFlowerDTO {


      @NotBlank(message = "название не должно быть пустым")
      private String title;

      @PositiveOrZero(message = "цена должна быть больше или равно 0")
      private  int price = 0;
      @PositiveOrZero(message = "наценка должна быть больше или равно 0")
      private  int extraCharge = 0;
      @PositiveOrZero(message = "Учётное количество должно быть больше или равно 0")
      private  int accountingQuantity = 0;
      @PositiveOrZero(message = "Фактиченское количество должно быть больше или равно 0")
      private  int actualQuantity = 0;


    public NewFlowerDTO(String title, int price, int extraCharge, int accountingQuantity, int actualQuantity) {
        this.title = title;
        this.price = price;
        this.extraCharge = extraCharge;
        this.accountingQuantity = accountingQuantity;
        this.actualQuantity = actualQuantity;
    }

    public NewFlowerDTO() {
    }
}


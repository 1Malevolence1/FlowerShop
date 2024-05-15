package com.example.managerapp.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateFlowerDTO {

    private String title;


    private  int price = 0;

    private  int extraCharge = 0;

    private  int accountingQuantity = 0;

    private  int actualQuantity = 0;

    public UpdateFlowerDTO(String title, int price, int extraCharge, int accountingQuantity, int actualQuantity) {
        this.title = title;
        this.price = price;
        this.extraCharge = extraCharge;
        this.accountingQuantity = accountingQuantity;
        this.actualQuantity = actualQuantity;
    }

    public UpdateFlowerDTO() {
    }
}

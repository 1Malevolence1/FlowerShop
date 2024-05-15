package com.example.managerapp.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateFlowerDTO {

    private String title;


    private  Integer price = 0;

    private  Integer extraCharge = 0;

    private  Integer accountingQuantity = 0;

    private  Integer actualQuantity = 0;

    public UpdateFlowerDTO(String title, Integer price, Integer extraCharge, Integer accountingQuantity, Integer actualQuantity) {
        this.title = title;
        this.price = price;
        this.extraCharge = extraCharge;
        this.accountingQuantity = accountingQuantity;
        this.actualQuantity = actualQuantity;
    }

    public UpdateFlowerDTO() {
    }
}

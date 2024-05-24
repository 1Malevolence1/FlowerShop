package com.example.managerapp.dto.flower.individual_flower;


import lombok.Data;


@Data
public class NewFlowerDTO {


    private String title;


    private  Integer price = 0;

    private  Integer extraCharge = 0;

    private  Integer accountingQuantity = 0;

    private  Integer actualQuantity = 0;


    public NewFlowerDTO(String title, Integer price, Integer extraCharge, Integer accountingQuantity, Integer actualQuantity) {
        this.title = title;
        this.price = price;
        this.extraCharge = extraCharge;
        this.accountingQuantity = accountingQuantity;
        this.actualQuantity = actualQuantity;
    }

    public NewFlowerDTO() {
    }

}


package com.example.managerapp.DTO;


import lombok.Data;


@Data
public class NewFlowerDTO {


    private String title;


    private  int price = 0;

    private  int extraCharge = 0;

    private  int accountingQuantity = 0;

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


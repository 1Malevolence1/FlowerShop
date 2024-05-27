package com.example.managerapp.dto.flower.individual_flower;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewFlowerDTO {


    private String title;


    private  Integer price = 0;

    private  Integer extraCharge = 0;

    private  Integer accountingQuantity = 0;

    private  Integer actualQuantity = 0;

    private String type;

    private String supplierName;


}


package com.example.managerapp.dto.flower.individual_flower;


import com.example.managerapp.dto.flower.inventory.Inventory;

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

    private Inventory inventory;

    private String type;

    private String supplierName;


}


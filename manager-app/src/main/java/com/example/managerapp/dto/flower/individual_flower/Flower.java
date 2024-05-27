package com.example.managerapp.dto.flower.individual_flower;

import com.example.managerapp.dto.flower.inventory.Inventory;
import com.example.managerapp.dto.flower.type_flower.TypeFlower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flower {
    private Long id;
    private String title;
    private Integer price;
    private Integer extraCharge;
    private Inventory inventory;
    private TypeFlower typeFlower;

}

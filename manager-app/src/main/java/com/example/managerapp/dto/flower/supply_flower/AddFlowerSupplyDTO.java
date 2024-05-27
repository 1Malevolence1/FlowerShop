package com.example.managerapp.dto.flower.supply_flower;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddFlowerSupplyDTO {
    private Long flowerId;
    private Integer addedQuantity;
}

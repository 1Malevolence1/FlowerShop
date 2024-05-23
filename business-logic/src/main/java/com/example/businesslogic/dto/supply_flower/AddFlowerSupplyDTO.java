package com.example.businesslogic.dto.supply_flower;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddFlowerSupplyDTO {
    private Long flowerId;
    private Integer addedQuantity;
}

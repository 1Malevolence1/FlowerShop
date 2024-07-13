package com.example.managerapp.dto.flower.inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {
    private Long id;
    private Integer accountingQuantity = 0;
    private Integer actualQuantity = 0;
}

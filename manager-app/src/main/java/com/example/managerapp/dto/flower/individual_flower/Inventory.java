package com.example.managerapp.dto.flower.individual_flower;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {
    private Long id;

    private Integer accountingQuantity;

    private Integer actualQuantity;
}

package com.example.managerapp.dto.flower.supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private Long id;
    private String supplierName;
    private String city;
    private String address;
    private Contact contact;
}

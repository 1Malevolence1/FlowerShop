package com.example.businesslogic.dto.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSupplierDTO {
    private Long id;
    private String supplierName;
    private String city;
    private String address;
    private Contact contact;
}

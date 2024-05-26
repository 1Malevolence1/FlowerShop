package com.example.businesslogic.dto.supplier;

import com.example.businesslogic.models.flower.Flower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;



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

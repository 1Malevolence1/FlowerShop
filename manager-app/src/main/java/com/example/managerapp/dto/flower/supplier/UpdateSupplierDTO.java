package com.example.managerapp.dto.flower.supplier;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;

@Data
@NoArgsConstructor
@AutoConfigureAfter
public class UpdateSupplierDTO {
    private String supplierName;
    private String city;
    private String address;
    private Contact contact;
}

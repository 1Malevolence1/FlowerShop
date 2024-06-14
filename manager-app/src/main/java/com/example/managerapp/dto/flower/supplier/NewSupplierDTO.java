package com.example.managerapp.dto.flower.supplier;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewSupplierDTO {
    private String supplierName;
    private String city;
    private String address;
    private Contact contact;

    public NewSupplierDTO(String supplierName, String city, String address) {
        this.supplierName = supplierName;
        this.city = city;
        this.address = address;
    }
}

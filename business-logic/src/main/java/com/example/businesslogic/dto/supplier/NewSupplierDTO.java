package com.example.businesslogic.dto.supplier;

import com.example.businesslogic.models.flower.Flower;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewSupplierDTO {

    private Long id;
    private String supplierName;
    private String city;
    private String contactPhone;
    private String contactEmail;
    private String address;

}

package com.example.businesslogic.dto.supplier;

import com.example.businesslogic.models.flower.Flower;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewSupplierDTO {

    @NotBlank(message = "поле кампания не должна быть пустым")
    private String supplierName;
    @NotBlank(message = "поле город не должно быть пустым")
    private String city;

    @NotBlank(message = "поле адресс не должно быть пустым")
    private String address;

    private Contact contact;
}

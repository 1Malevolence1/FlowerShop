package com.example.businesslogic.dto.supplier;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewSupplierDTO {

    @NotBlank(message = "поле кампания не должно быть пустым")
    private String supplierName;

    private String city;

    @NotBlank(message = "поле адресс не должно быть пустым")
    private String address;

    @Valid
    private Contact contact;
}

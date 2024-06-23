package com.example.businesslogic.dto.individual_flower.supplier;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewSupplierDTO {

    private Long id;

    @NotBlank(message = "поле кампания не должно быть пустым")
    private String supplierName;

    @NotBlank(message = "поле город не должно быть пустым")
    private String city;

    @NotBlank(message = "поле адресс не должно быть пустым")
    private String address;

    @Valid
    private ContactDto contact;
}

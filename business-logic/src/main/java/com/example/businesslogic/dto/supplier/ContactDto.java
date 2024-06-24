package com.example.businesslogic.dto.supplier;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    @NotBlank(message = "поле имя не должно быть пустым")
    private String contactName;
    @NotBlank(message = "поле телефон не должно быть пустым")
    private String contactPhone;
    @NotBlank(message = "поле почта не должно быть пустым")
    private String email;
}

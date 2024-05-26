package com.example.businesslogic.dto.supplier;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @NotBlank(message = "поле имя не должно быть пустым")
    private String name;
    @NotBlank(message = "поле телефон не должно быть пустым")
    private String phone;
    private String email;
}

package com.example.businesslogic.dto.type_flower;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewTypeFlowerDTO {

    @NotBlank(message = """
            поле "Тип" не может быть пустым
            """)
    private String type;
    private String description;
}

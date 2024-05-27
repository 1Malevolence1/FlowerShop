package com.example.managerapp.dto.flower.supplier;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contact {
    private String contactPhone;
    private String contactName;
    private String email;
}

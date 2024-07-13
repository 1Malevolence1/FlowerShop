package com.example.managerapp.security.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class DtoMyUser {

    private String username;
    private String password;
    private String role;
}

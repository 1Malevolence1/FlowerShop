package com.example.businesslogic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "manager", name = "type_flower")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeFlower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_flower_id")
    private Long id;

    @Column(name = "type_name")
    private String type;

    @Column(name = "description")
    private String description;
}

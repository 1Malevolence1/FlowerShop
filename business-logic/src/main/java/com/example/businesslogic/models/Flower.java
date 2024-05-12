package com.example.businesslogic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "manager", name = "flower")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

    @Column(name = "extra_charge")
    private Double extraCharge;



    @Column(name = "accountingQuantity")
    private Double accountingQuantity;

    @Column(name = "actualQuantity")
    private Double actualQuantity;



}

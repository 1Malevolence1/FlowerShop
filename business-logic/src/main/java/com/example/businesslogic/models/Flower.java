package com.example.businesslogic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(schema = "manager", name = "flowers")
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
    private Integer accountingQuantity;

    @Column(name = "actualQuantity")
    private Integer actualQuantity;



}

package com.example.businesslogic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(schema = "manager", name = "flowers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flower_id")
    private Long id;


    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "extra_charge")
    private Integer extraCharge;



    @Column(name = "accountingQuantity")
    private Integer accountingQuantity;

    @Column(name = "actualQuantity")
    private Integer actualQuantity;


    @ManyToOne
    @JoinTable(
            schema = "manager", name = "flower_type_relation",
            joinColumns = @JoinColumn(name = "flower_id"),
            inverseJoinColumns = @JoinColumn(name = "type_flower_id")
    )
    private TypeFlower typeFlower;
}

package com.example.businesslogic.models.flower.inventory;


import com.example.businesslogic.models.flower.Flower;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(schema = "flowers", name = "inventory_flower")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;


    @Column(name = "accounting_quantity")
    private Integer accountingQuantity;

    @Column(name = "actual_quantity")
    private Integer actualQuantity;


    public Inventory(Integer accountingQuantity, Integer actualQuantity) {

        this.accountingQuantity = accountingQuantity;
        this.actualQuantity = actualQuantity;
    }
}

package com.example.businesslogic.models.flower.inventory;


import com.example.businesslogic.models.flower.Flower;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(schema = "flowers", name = "inventory_flower")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flower_id", referencedColumnName = "flower_id")
    @ToString.Exclude
    @JsonIgnore
    private Flower flower;

    @Column(name = "accounting_quantity")
    private Integer accountingQuantity;

    @Column(name = "actual_quantity")
    private Integer actualQuantity;


    public Inventory(Flower flower, Integer accountingQuantity, Integer actualQuantity) {
        this.flower = flower;
        this.accountingQuantity = accountingQuantity;
        this.actualQuantity = actualQuantity;
    }
}

package com.example.businesslogic.models.flower;

import com.example.businesslogic.models.flower.inventory.Inventory;
import com.example.businesslogic.models.flower.suppliers.Supplier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(schema = "flowers", name = "flowers")
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    @ToString.Exclude
    private Inventory inventory;


    @ManyToOne()
    @JoinTable(
            schema = "flowers", name = "flower_type_relation",
            joinColumns = @JoinColumn(name = "flower_id"),
            inverseJoinColumns = @JoinColumn(name = "type_flower_id")
    )
    @ToString.Exclude
    private TypeFlower typeFlower;


    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    @ToString.Exclude
    private Supplier suppliers;

}

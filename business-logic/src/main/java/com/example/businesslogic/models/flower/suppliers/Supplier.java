package com.example.businesslogic.models.flower.suppliers;

import com.example.businesslogic.models.flower.Flower;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Entity
@Table(schema = "flowers", name = "suppliers")
@Data
@NoArgsConstructor
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "city")
    private String city;


    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flower> flowers;


    @OneToOne(mappedBy = "suppliers", cascade = CascadeType.ALL)
    private Contact contact;

    public Supplier(Long id, String supplierName, String city, String address, Contact contact) {
        this.id = id;
        this.supplierName = supplierName;
        this.city = city;
        this.address = address;
        this.contact = contact;
    }
}

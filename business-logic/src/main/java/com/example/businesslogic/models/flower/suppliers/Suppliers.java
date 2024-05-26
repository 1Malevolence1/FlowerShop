package com.example.businesslogic.models.flower.suppliers;

import com.example.businesslogic.models.flower.Flower;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(schema = "flower", name = "suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "city")
    private String city;


    @Column(name = "contact_phone")
    private String contactPhone;


    @Column(name = "contact_email")
    private String contactEmail;


    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flower> flowers;


    public Suppliers(Long id, String supplierName, String city, String contactPhone, String contactEmail, String address) {
        this.id = id;
        this.supplierName = supplierName;
        this.city = city;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.address = address;
    }
}

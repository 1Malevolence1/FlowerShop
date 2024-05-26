package com.example.businesslogic.models.flower.suppliers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "flowers", name = "contact_supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    Long id;

    @Column(name = "supplier_contact")
    private String contactPhone;

    @Column(name = "supplier_name")
    private String contactName;

    @Column(name = "supplier_email")
    private String email;

    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
    @JsonIgnore
    private Supplier suppliers;


    public Contact(String contactName, String contactPhone, String email) {
        this.contactPhone = contactPhone;
        this.contactName = contactName;
        this.email = email;
    }
}

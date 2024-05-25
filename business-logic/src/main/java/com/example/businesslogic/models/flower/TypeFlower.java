package com.example.businesslogic.models.flower;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
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
    private String typeName;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "typeFlower", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Flower> flowers;


    public TypeFlower(Long id, String typeName, String description) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
    }


}

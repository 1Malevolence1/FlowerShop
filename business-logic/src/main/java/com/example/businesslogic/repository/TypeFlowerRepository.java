package com.example.businesslogic.repository;

import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.TypeFlower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeFlowerRepository extends JpaRepository<TypeFlower, Long> {
}

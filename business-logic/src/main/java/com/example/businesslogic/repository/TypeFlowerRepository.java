package com.example.businesslogic.repository;

import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.TypeFlower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TypeFlowerRepository extends JpaRepository<TypeFlower, Long> {

    Optional<TypeFlower> findByTypeName(String typeFlower);
}

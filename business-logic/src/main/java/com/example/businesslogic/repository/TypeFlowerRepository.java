package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.TypeFlower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeFlowerRepository extends JpaRepository<TypeFlower, Long> {

    Optional<TypeFlower> findByTypeName(String typeFlower);
}

package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.Flower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
}

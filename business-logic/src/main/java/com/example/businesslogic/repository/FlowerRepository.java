package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

}

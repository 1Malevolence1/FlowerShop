package com.example.businesslogic.repository;

import com.example.businesslogic.models.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FlowerRepository extends JpaRepository<Flower, Long> {
}

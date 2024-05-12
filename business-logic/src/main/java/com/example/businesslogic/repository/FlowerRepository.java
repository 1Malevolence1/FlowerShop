package com.example.businesslogic.repository;

import com.example.businesslogic.models.Flower;
import org.springframework.data.repository.CrudRepository;

public interface FlowerRepository extends CrudRepository<Flower, Long> {
}

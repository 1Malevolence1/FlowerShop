package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.suppliers.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Supplier, Long> {
}

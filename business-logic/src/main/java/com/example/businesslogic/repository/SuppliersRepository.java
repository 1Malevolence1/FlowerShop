package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.suppliers.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
}

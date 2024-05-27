package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.suppliers.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface SuppliersRepository extends JpaRepository<Supplier, Long> {

    Supplier findBySupplierName(String name);
}

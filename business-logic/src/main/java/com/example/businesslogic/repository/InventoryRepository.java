package com.example.businesslogic.repository;

import com.example.businesslogic.models.flower.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
}

package com.example.inventorymanagementsystem.repository;

import com.example.inventorymanagementsystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Product, Long> {
}

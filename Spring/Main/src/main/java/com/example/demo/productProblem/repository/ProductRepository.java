package com.example.demo.productProblem.repository;

import com.example.demo.productProblem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

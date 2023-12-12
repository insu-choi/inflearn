package com.example.productorderservice1.product.adapter;

import com.example.productorderservice1.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

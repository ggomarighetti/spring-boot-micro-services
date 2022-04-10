package com.ggomarighetti.microservices.products.repository;

import com.ggomarighetti.microservices.commons.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    public ProductEntity findByName(String name);
}

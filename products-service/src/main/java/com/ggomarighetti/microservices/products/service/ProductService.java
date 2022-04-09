package com.ggomarighetti.microservices.products.service;

import com.ggomarighetti.microservices.products.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    public List<ProductEntity> findAll();

    public ProductEntity findById(String id);
}

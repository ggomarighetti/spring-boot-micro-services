package com.ggomarighetti.microservices.products.service;

import com.ggomarighetti.microservices.commons.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    public List<ProductEntity> findAll();

    public ProductEntity findById(String id);

    public ProductEntity save(ProductEntity productEntity);

    public ProductEntity update(ProductEntity productEntity);

    public void deleteById(String id);
}

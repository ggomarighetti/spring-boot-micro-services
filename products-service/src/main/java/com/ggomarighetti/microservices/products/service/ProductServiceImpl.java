package com.ggomarighetti.microservices.products.service;

import com.ggomarighetti.microservices.products.entity.ProductEntity;
import com.ggomarighetti.microservices.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public ProductEntity findById(String id) {
        return productRepository.findById(id).orElse(null);
    }
}

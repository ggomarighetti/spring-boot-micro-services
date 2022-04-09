package com.ggomarighetti.microservices.products.controller;

import com.ggomarighetti.microservices.products.entity.ProductEntity;
import com.ggomarighetti.microservices.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<ProductEntity> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductEntity findById(@PathVariable String id) {
        return productService.findById(id);
    }
}

package com.ggomarighetti.microservices.products.controller;

import com.ggomarighetti.microservices.products.entity.ProductEntity;
import com.ggomarighetti.microservices.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    public ProductEntity findById(@PathVariable String id) throws InterruptedException {

        Integer random = new Random().nextInt(3);

        switch (random) {
            case 1:
                throw new IllegalStateException("Product not found");

            case 2:
                TimeUnit.SECONDS.sleep(10L);
        }

        return productService.findById(id);
    }
}

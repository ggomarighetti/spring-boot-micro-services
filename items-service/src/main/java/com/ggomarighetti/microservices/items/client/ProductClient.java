package com.ggomarighetti.microservices.items.client;

import com.ggomarighetti.microservices.items.entity.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products-service")
public interface ProductClient {

    @GetMapping("/")
    public List<ProductEntity> findAll();

    @GetMapping("/{id}")
    public ProductEntity findById(@PathVariable String id);
}

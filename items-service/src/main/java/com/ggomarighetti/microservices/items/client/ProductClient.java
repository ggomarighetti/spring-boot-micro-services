package com.ggomarighetti.microservices.items.client;

import com.ggomarighetti.microservices.commons.entity.ProductEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "products-service")
public interface ProductClient {

    @GetMapping("/")
    public List<ProductEntity> findAll();

    @GetMapping("/{id}")
    public ProductEntity findById(@PathVariable String id);

    @PostMapping("/")
    public ProductEntity save(@RequestBody ProductEntity productEntity);

    @PutMapping("/")
    public ProductEntity update(@RequestBody ProductEntity productEntity);

    @DeleteMapping("/")
    public void deleteById(@PathVariable String id);
}

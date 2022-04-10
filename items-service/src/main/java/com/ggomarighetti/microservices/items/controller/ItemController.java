package com.ggomarighetti.microservices.items.controller;

import com.ggomarighetti.microservices.items.entity.ItemEntity;
import com.ggomarighetti.microservices.items.entity.ProductEntity;
import com.ggomarighetti.microservices.items.service.ItemService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@RestController
public class ItemController {

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<ItemEntity> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemEntity findById(@PathVariable String id) {
        return circuitBreakerFactory.create("items")
                .run(() -> itemService.findById(id), e -> alternativeFindById(id));
    }

    @GetMapping("/{id}/circuitBreaker")
    @CircuitBreaker(name = "items", fallbackMethod = "alternativeFindById")
    public ItemEntity findByIdCircuitBreaker(@PathVariable String id) {
        return itemService.findById(id);
    }

    @GetMapping("/{id}/timeLimiter")
    @TimeLimiter(name = "items", fallbackMethod = "alternativeFindByIdTimeLimiter")
    public CompletableFuture<ItemEntity> findByIdTimeLimiter(@PathVariable String id) {
        return CompletableFuture.supplyAsync(() -> itemService.findById(id));
    }

    public ItemEntity alternativeFindById(String id) {

        ProductEntity productEntity = ProductEntity.builder()
                .id(id)
                .name("Circuit Breaker Product")
                .price(BigDecimal.valueOf(Math.random()))
                .build();

        ItemEntity itemEntity = ItemEntity.builder()
                .product(productEntity)
                .quantity(new Random().nextInt())
                .build();

        return itemEntity;
    }

    public CompletableFuture<ItemEntity> alternativeFindByIdTimeLimiter(String id) {

        ProductEntity productEntity = ProductEntity.builder()
                .id(id)
                .name("Circuit Breaker Product")
                .price(BigDecimal.valueOf(Math.random()))
                .build();

        ItemEntity itemEntity = ItemEntity.builder()
                .product(productEntity)
                .quantity(new Random().nextInt())
                .build();

        return CompletableFuture.supplyAsync(() -> itemEntity);
    }
}

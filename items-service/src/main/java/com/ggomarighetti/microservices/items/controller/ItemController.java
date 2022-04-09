package com.ggomarighetti.microservices.items.controller;

import com.ggomarighetti.microservices.items.entity.ItemEntity;
import com.ggomarighetti.microservices.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<ItemEntity> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ItemEntity findById(@PathVariable String id) {
        return itemService.findById(id);
    }
}

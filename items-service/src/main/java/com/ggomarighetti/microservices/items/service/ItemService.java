package com.ggomarighetti.microservices.items.service;

import com.ggomarighetti.microservices.items.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    public List<ItemEntity> findAll();

    public ItemEntity findById(String id);
}

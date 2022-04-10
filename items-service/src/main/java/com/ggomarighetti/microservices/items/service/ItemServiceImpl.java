package com.ggomarighetti.microservices.items.service;

import com.ggomarighetti.microservices.items.client.ProductClient;
import com.ggomarighetti.microservices.commons.entity.ItemEntity;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements  ItemService {

    @Autowired
    private ProductClient productClient;

    @Override
    public List<ItemEntity> findAll() {
        return productClient.findAll().stream().map(p -> ItemEntity.builder().product(p).quantity(1).build()).collect(Collectors.toList());
    }

    @Override
    public ItemEntity findById(String id) {
        return ItemEntity.builder().product(productClient.findById(id)).quantity(1).build();
    }
}

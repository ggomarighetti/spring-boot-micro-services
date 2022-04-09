package com.ggomarighetti.microservices.products.seeder;

import com.ggomarighetti.microservices.products.entity.ProductEntity;
import com.ggomarighetti.microservices.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class ProductSeeder implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySeeded = false;

    @Autowired
    private ProductRepository productRepository;

    private static final String[] PRODUCTS = {
            "Keyboard",
            "Mouse",
            "Headset",
            "Monitor",
            "Processor",
            "Graphic Card",
            "Hard Disk",
            "Solid State Drive",
    };

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySeeded)
            return;

        for (String product : PRODUCTS) {
            createProductIfNotFound(product);
        }
    }

    @Transactional
    void createProductIfNotFound(String name) {

        ProductEntity productEntity = productRepository.findByName(name);

        if (productEntity == null) {

            productEntity = ProductEntity.builder()
                    .name(name)
                    .price(BigDecimal.valueOf(Math.random()))
                    .build();

            productRepository.save(productEntity);
        }

        return;
    }
}

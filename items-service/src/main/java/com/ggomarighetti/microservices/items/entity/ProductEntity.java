package com.ggomarighetti.microservices.items.entity;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    private String id;
    private String name;
    private BigDecimal price;
}

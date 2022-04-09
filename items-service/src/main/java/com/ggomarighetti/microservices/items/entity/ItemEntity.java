package com.ggomarighetti.microservices.items.entity;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    private ProductEntity product;
    private Integer quantity;

    public BigDecimal getTotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}

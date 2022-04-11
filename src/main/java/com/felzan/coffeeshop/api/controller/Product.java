package com.felzan.coffeeshop.api.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String image;
    private String title;
    private String subtitle;
    private String description;
    private BigDecimal price;
}

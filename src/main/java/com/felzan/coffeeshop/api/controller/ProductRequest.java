package com.felzan.coffeeshop.api.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String image;
    private String title;
    private String subtitle;
    private String description;
    private BigDecimal price;
    private String categoryId;
}

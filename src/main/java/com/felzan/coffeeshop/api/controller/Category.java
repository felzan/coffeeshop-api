package com.felzan.coffeeshop.api.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private String id;
    private String image;
    private String title;
    private String description;
    private List<Product> products;

}

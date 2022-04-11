package com.felzan.coffeeshop.api.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private String clientName;
    private BigDecimal total;
    private List<String> items;
    private boolean paid;
}

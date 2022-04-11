package com.felzan.coffeeshop.api.controller;

import com.felzan.coffeeshop.api.repository.OrderDocument;
import com.felzan.coffeeshop.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/orders", produces = APPLICATION_JSON_VALUE)
public class OrderController {

    private final OrderService orderService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDocument> postOrder(@RequestBody OrderRequest request) {
        return ResponseEntity.ok().body(orderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderDocument>> getOrders() {
        return ResponseEntity.ok().body(orderService.getOrders());
    }
}

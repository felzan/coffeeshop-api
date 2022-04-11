package com.felzan.coffeeshop.api.controller;

import com.felzan.coffeeshop.api.repository.ProductDocument;
import com.felzan.coffeeshop.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/products", produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDocument> postProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok().body(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductDocument>> getProducts() {
        return ResponseEntity.ok().body(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDocument> getStoreById(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }
}

package com.felzan.coffeeshop.api.service;


import com.felzan.coffeeshop.api.controller.ProductRequest;
import com.felzan.coffeeshop.api.repository.ProductDocument;
import com.felzan.coffeeshop.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDocument createProduct(ProductRequest request) {
        var document = ProductDocument.builder()
                .image(request.getImage())
                .title(request.getTitle())
                .subtitle(request.getSubtitle())
                .description(request.getDescription())
                .price(request.getPrice())
                .categoryId(request.getCategoryId())
                .build();
        return productRepository.save(document);
    }

    public List<ProductDocument> getProducts() {
        return productRepository.findAll();
    }

    public ProductDocument getProductById(String id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<ProductDocument> getAllProductsByIds(List<String> ids) {
        List<ProductDocument> list = new ArrayList<>();
        Iterable<ProductDocument> documents = productRepository.findAllById(ids);
        documents.forEach(list::add);
        return list;
    }

    public List<ProductDocument> getProductsByCategoryId(String id) {
        return productRepository.findAllByCategoryId(id);
    }
}

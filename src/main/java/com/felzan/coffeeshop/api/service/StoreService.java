package com.felzan.coffeeshop.api.service;


import com.felzan.coffeeshop.api.controller.Category;
import com.felzan.coffeeshop.api.controller.MenuResponse;
import com.felzan.coffeeshop.api.controller.Product;
import com.felzan.coffeeshop.api.controller.StoreRequest;
import com.felzan.coffeeshop.api.repository.CategoryDocument;
import com.felzan.coffeeshop.api.repository.ProductDocument;
import com.felzan.coffeeshop.api.repository.StoreDocument;
import com.felzan.coffeeshop.api.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CategoryService categoryService;
    private final ProductService productService;

    public StoreDocument createStore(StoreRequest request) {
        var document = StoreDocument.builder()
                .image(request.getImage())
                .name(request.getName())
                .address(request.getAddress())
                .city(request.getCity())
                .lat(request.getLat())
                .lon(request.getLon())
                .openingHours(request.getOpeningHours())
                .build();
        return storeRepository.save(document);
    }

    public List<StoreDocument> getStores() {
        return storeRepository.findAll();
    }

    public StoreDocument getStoreById(String id) {
        return storeRepository.findById(id).orElseThrow();
    }

    //TODO: Cache
    public MenuResponse getMenuByStoreId(String id) {
        List<ProductDocument> productDocuments = productService.getProducts();
        List<CategoryDocument> categoryDocuments = categoryService.getCategories();
        List<Category> categories = categoryDocuments.stream()
                .map(category -> Category.builder()
                        .id(category.getId())
                        .image(category.getImage())
                        .title(category.getTitle())
                        .description(category.getDescription())
                        .products(productDocuments.stream().filter(product -> product.getCategoryId().equals(category.getId())).map(product -> Product.builder().id(product.getId()).image(product.getImage()).title(product.getTitle()).subtitle(product.getSubtitle()).description(product.getDescription()).price(product.getPrice()).build()).collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
        return MenuResponse.builder().categories(categories).build();

    }
}

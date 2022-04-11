package com.felzan.coffeeshop.api.controller;

import com.felzan.coffeeshop.api.repository.CategoryDocument;
import com.felzan.coffeeshop.api.repository.ProductDocument;
import com.felzan.coffeeshop.api.service.CategoryService;
import com.felzan.coffeeshop.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/categories", produces = APPLICATION_JSON_VALUE)
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDocument> postCategory(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok().body(categoryService.createCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDocument>> getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDocument> getCategoryById(@PathVariable String id) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductDocument>> getProductsByCategoryId(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.getProductsByCategoryId(id));
    }
}

package com.felzan.coffeeshop.api.controller;

import com.felzan.coffeeshop.api.repository.CategoryDocument;
import com.felzan.coffeeshop.api.service.CategoryService;
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

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDocument> postStore(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok().body(categoryService.createCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDocument>> getStores() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDocument> getStoreById(@PathVariable String id) {
        return ResponseEntity.ok().body(categoryService.getCategoryById(id));
    }
}

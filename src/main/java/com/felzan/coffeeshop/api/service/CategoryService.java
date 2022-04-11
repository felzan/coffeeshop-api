package com.felzan.coffeeshop.api.service;


import com.felzan.coffeeshop.api.controller.CategoryRequest;
import com.felzan.coffeeshop.api.repository.CategoryDocument;
import com.felzan.coffeeshop.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryDocument createCategory(CategoryRequest request) {
        var document = CategoryDocument.builder()
                .image(request.getImage())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
        return categoryRepository.save(document);
    }

    public List<CategoryDocument> getCategories() {
        return categoryRepository.findAll();
    }

    public CategoryDocument getCategoryById(String id) {
        return categoryRepository.findById(id).orElseThrow();
    }
}

package com.felzan.coffeeshop.api.controller;

import com.felzan.coffeeshop.api.repository.StoreDocument;
import com.felzan.coffeeshop.api.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/stores", produces = APPLICATION_JSON_VALUE)
public class StoreController {

    private final StoreService storeService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<StoreDocument> postStore(@RequestBody StoreRequest request) {
        return ResponseEntity.ok().body(storeService.createStore(request));
    }

    @GetMapping
    public ResponseEntity<List<StoreDocument>> getStores() {
        return ResponseEntity.ok().body(storeService.getStores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDocument> getStoreById(@PathVariable String id) {
        return ResponseEntity.ok().body(storeService.getStoreById(id));
    }
}

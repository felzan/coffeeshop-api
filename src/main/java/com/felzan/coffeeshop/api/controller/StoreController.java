package com.felzan.coffeeshop.api.controller;

import com.felzan.coffeeshop.api.repository.StoreDocument;
import com.felzan.coffeeshop.api.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<StoreDocument> postStore(@RequestBody StoreRequest request) {
        return ResponseEntity.ok().body(storeService.createStore(request));
    }
}

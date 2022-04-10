package com.felzan.coffeeshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/stores")
public class StoreController {

    @PostMapping
    public ResponseEntity<?> postStore(@RequestBody StoreRequest request) {

        return ResponseEntity.ok().build();
    }
}

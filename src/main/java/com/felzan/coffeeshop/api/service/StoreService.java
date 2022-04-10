package com.felzan.coffeeshop.api.service;


import com.felzan.coffeeshop.api.controller.StoreRequest;
import com.felzan.coffeeshop.api.repository.StoreDocument;
import com.felzan.coffeeshop.api.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

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
}

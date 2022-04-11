package com.felzan.coffeeshop.api.service;

import com.felzan.coffeeshop.api.controller.OrderRequest;
import com.felzan.coffeeshop.api.repository.OrderDocument;
import com.felzan.coffeeshop.api.repository.OrderRepository;
import com.felzan.coffeeshop.api.repository.ProductDocument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderDocument createOrder(OrderRequest request) {
        List<ProductDocument> products = productService.getAllProductsByIds(request.getItems());
        var document = OrderDocument.builder()
                .clientName(request.getClientName())
                //TODO: validate total
                .total(request.getTotal())
                .products(products)
                .paid(request.isPaid())
                .build();
        return orderRepository.save(document);
    }

    public List<OrderDocument> getOrders() {
        return orderRepository.findAll();
    }
}

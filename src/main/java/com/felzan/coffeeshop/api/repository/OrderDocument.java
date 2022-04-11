package com.felzan.coffeeshop.api.repository;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order")
public class OrderDocument {

    @Id
    private String id;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    private String clientName;
    private BigDecimal total;
    private List<ProductDocument> products;
    private boolean paid;

}

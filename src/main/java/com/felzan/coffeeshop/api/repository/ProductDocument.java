package com.felzan.coffeeshop.api.repository;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class ProductDocument {

    @Id
    private String id;
    private String image;
    private String title;
    private String subtitle;
    private String description;
    private BigDecimal price;
    @Indexed
    private String categoryId;
}

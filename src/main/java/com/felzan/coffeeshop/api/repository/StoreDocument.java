package com.felzan.coffeeshop.api.repository;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "store")
public class StoreDocument {

    @Id
    private String id;
    private String image;
    private String name;
    private String address;
    private String city;
    private Double lat;
    private Double lon;
    private Map<String, String> openingHours;

}

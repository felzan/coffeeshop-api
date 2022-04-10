package com.felzan.coffeeshop.api.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreRequest {

//    private String id;
    private String image;
    private String name;
    private String address;
    private String city;
    private Double lat;
    private Double lon;
    private Map<String, String> openingHours;
    /* Mon to Fri: 08:30 - 20:00
     * Sat: 08:30 - 20:00
     * Sun: 09:00 - 19:00
     */
}

package com.felzan.coffeeshop.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductDocument, String> {

    List<ProductDocument> findAllByCategoryId(String id);
}

package com.scart.productservice.repository;

import com.scart.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,Integer> {


    List<Product> findByCategory(String category);

    Optional<Product> findByProductName(String productName);

    List<Product> findByProductType(String productType);

}

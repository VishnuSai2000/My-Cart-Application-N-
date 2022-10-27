package com.scart.CartService.repository;

import com.scart.CartService.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CartRepository extends MongoRepository<Cart, Integer> {
}

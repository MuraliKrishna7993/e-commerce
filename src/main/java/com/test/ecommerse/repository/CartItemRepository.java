package com.test.ecommerse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.ecommerse.model.CartItem;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem, Integer> {

}

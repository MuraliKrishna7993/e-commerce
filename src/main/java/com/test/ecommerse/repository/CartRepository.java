package com.test.ecommerse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.ecommerse.model.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer> {

}

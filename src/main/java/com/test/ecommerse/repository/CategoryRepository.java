package com.test.ecommerse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.ecommerse.model.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Integer> {

}

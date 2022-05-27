package com.test.ecommerse.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.ecommerse.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {

	@Query(value = "{'productName':?0}", fields = "{'productId':0,'category':0,'productRating':0,'productReview':0}")
	List<Product> findByProductName(String productName);

	List<Product> findByCategoryCategoryName(String categoryName);

	@Query(value = "{'category.categoryName':?0,'productName':?1}", fields = "{'productId':0,'category':0,'productRating':0,'productReview':0}")
	List<Product> findByCategoryCategoryNameAndProductName(String categoryName, String productName);

}

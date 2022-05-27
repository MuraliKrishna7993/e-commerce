package com.test.ecommerse.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.ecommerse.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

	// @Query(value="{'userDetails.userId':?0}")
	List<Order> findByUserDetailsUserId(Integer userId);

}

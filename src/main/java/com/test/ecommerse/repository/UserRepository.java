package com.test.ecommerse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.ecommerse.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

	@Query(value = "{'userName':?0}")
	User findByUserName(String userName);

}

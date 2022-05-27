package com.test.ecommerse.serviceInteface;

import java.util.List;

import com.test.ecommerse.model.User;

public interface UserService {

	User createUser(User user);

	List<User> listUsers();

	User getSingleUser(Integer userId);

	void deleteUser(Integer userId);

	User editUser(User updateUser);

}

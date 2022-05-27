package com.test.ecommerse.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.ecommerse.model.User;
import com.test.ecommerse.serviceImplementation.UserServiceImplementation;

@RestController
public class UserController {

	@Autowired
	UserServiceImplementation userserviceimpl;

	@PostMapping("/SignUp")
	public User addUser(@RequestBody User user) {
		return userserviceimpl.createUser(user);

	}

	@GetMapping("/Users")
	public List<User> listAllUsers() {
		return userserviceimpl.listUsers();
	}

	@GetMapping("/Users/{userId}")
	public User getUser(@PathVariable Integer userId) {
		return userserviceimpl.getSingleUser(userId);
	}

	@DeleteMapping("/Users/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userserviceimpl.deleteUser(userId);
	}

	@PutMapping("/Users/{userId}")
	public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
		user.setUserId(userId);
		return userserviceimpl.editUser(user);

	}

}

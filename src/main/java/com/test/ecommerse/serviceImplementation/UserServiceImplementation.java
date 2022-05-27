
package com.test.ecommerse.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ecommerse.model.User;
import com.test.ecommerse.repository.UserRepository;
import com.test.ecommerse.serviceInteface.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.insert(user);
	}

	@Override
	public List<User> listUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getSingleUser(Integer userId) {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new RuntimeException("User Not Found");
		}
	}

	@Override
	public void deleteUser(Integer userId) {
		userRepo.deleteById(userId);

	}

	@Override
	public User editUser(User updateUser) {
		return userRepo.save(updateUser);
	}

}

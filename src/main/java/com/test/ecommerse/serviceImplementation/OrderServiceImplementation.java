package com.test.ecommerse.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ecommerse.model.Order;
import com.test.ecommerse.repository.OrderRepository;
import com.test.ecommerse.serviceInteface.OrderService;

@Service
public class OrderServiceImplementation implements OrderService {

	@Autowired
	OrderRepository orderrepo;

	public Order createOrder(Order order) {

		return orderrepo.insert(order);
	}

	public List<Order> getOrderByUserId(Integer userId) {
		return orderrepo.findByUserDetailsUserId(userId);
	}

}

package com.test.ecommerse.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.ecommerse.model.Order;
import com.test.ecommerse.serviceImplementation.OrderServiceImplementation;

@RestController
public class OrderController {

	@Autowired
	OrderServiceImplementation orderserviceimpl;

	@PostMapping("/Order")
	public Order saveOrder(@RequestBody Order order) {
		return orderserviceimpl.createOrder(order);
	}

	@GetMapping("/Users/{userId}/Orders")
	public List<Order> getOrdersByUserId(@PathVariable Integer userId) {
		return orderserviceimpl.getOrderByUserId(userId);
	}

}

package com.test.ecommerse.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.ecommerse.model.CartItem;
import com.test.ecommerse.repository.CartRepository;
import com.test.ecommerse.serviceImplementation.CartServiceImplementation;

@RestController
public class CartController {

	@Autowired
	CartRepository repo;

	@Autowired
	CartServiceImplementation cartserviceimpl;

	@PostMapping("addToCart/{cartId}")
	public String addToCart(@PathVariable("cartId") Integer cartId, @RequestBody CartItem item) {
		cartserviceimpl.addItem(cartId, item);
		return "added";
	}

	@DeleteMapping("Cart/{cartId}/cartItem/{cartItemId}")
	public String deleteCartItem(@PathVariable("cartId") Integer cartId, @PathVariable("cartItemId") Integer itemId) {

		cartserviceimpl.deleteItem(cartId, itemId);
		return "deleted";

	}

	@PutMapping("Cart/{cartId}/cartItem/{cartItemId}")
	public String updateQuantity(@PathVariable("cartId") Integer cartId, @PathVariable("cartItemId") Integer itemId,
			@RequestParam("quantity") Integer quantity) {

		return cartserviceimpl.updateQuantity(cartId, itemId, quantity);
	}

}

package com.test.ecommerse.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ecommerse.model.Cart;
import com.test.ecommerse.model.CartItem;
import com.test.ecommerse.repository.CartRepository;
import com.test.ecommerse.serviceInteface.CartService;

@Service
public class CartServiceImplementation implements CartService {

	@Autowired
	CartRepository repo;

	public void addItem(Integer cartId, CartItem item) {
		Cart cart = null;

		Optional<Cart> cartOptional = repo.findById(cartId);
		if (cartOptional.isPresent()) {
			cart = cartOptional.get();
		} else {
			cart = new Cart();
		}
		cart.setCartId(cartId);
		cart.addToCart(item);
		cart.getGrandTotal();
		repo.save(cart);

	}

	public void deleteItem(Integer cartId, Integer itemId) {
		Optional<Cart> cartOptional = repo.findById(cartId);
		if (cartOptional.isPresent()) {
			List<CartItem> newItems = new ArrayList<>();
			Cart cart = cartOptional.get();
			List<CartItem> cartItems = cart.getCartitems();
			for (CartItem cartItem : cartItems) {
				if (cartItem.getCartItemId() == itemId) {
					continue;
				}
				newItems.add(cartItem);
			}
			cart.setCartItems(newItems);
			repo.save(cart);

		} else {
			throw new RuntimeException("Cart not Found");
		}
	}

	public String updateQuantity(Integer cartId, Integer itemId, Integer quantity) {
		Optional<Cart> cartOptional = repo.findById(cartId);
		if (cartOptional.isPresent()) {
			boolean itemfound = false;

			Cart cart = cartOptional.get();
			List<CartItem> cartItems = cart.getCartitems();
			for (CartItem cartItem : cartItems) {
				if (cartItem.getCartItemId() == itemId) {
					cartItem.setQuantity(quantity);
					itemfound = true;
				}

			}
			if (itemfound) {
				cart.setCartItems(cartItems);
				repo.save(cart);
				return "updated successfully";
			} else {
				return " CartItem Not Found";
			}

		} else {
			return "Cart not Found";
		}
	}

}

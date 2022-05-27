package com.test.ecommerse.serviceInteface;

import com.test.ecommerse.model.CartItem;

public interface CartService {
	public void addItem(Integer cartId, CartItem item);

	public void deleteItem(Integer cartId, Integer itemId);
}

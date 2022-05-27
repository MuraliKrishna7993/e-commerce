package com.test.ecommerse.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {

	@Id
	private Integer cartId;

	private List<CartItem> cartitems = new ArrayList<>();

	private Double grandTotal = 0D;

	public Double getGrandTotal() {
		grandTotal = 0d;
		List<CartItem> cartitems = getCartitems();
		for (CartItem item : cartitems) {
			this.grandTotal = grandTotal + item.getSubTotal();
		}
		return grandTotal;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public List<CartItem> getCartitems() {
		return cartitems;
	}

	public boolean addToCart(CartItem item) {
		return this.cartitems.add(item);
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void setCartItems(List<CartItem> newItems) {
		this.cartitems = newItems;
		getGrandTotal();

	}

	public Cart(Integer cartId, List<CartItem> cartitems, Double grandTotal) {
		super();
		this.cartId = cartId;
		this.cartitems = cartitems;
		// this.grandTotal = grandTotal;
		getGrandTotal();
	}

	public Cart() {
		super();
	}

}

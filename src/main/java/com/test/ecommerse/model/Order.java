package com.test.ecommerse.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {

	@Id
	private String orderId;

	private Cart cartDetails;

	private User userDetails;

	private Address shippingAddress;

	private Payment paymentMethods;

	private Card cardDetails;

	private Date orderDate = new Date();

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Cart getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Cart cartDetails) {
		this.cartDetails = cartDetails;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Payment getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(Payment paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Card getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(Card cardDetails) {
		this.cardDetails = cardDetails;
	}

	public Order(String orderId, Cart cartDetails, User userDetails, Address shippingAddress, Payment paymentMethods,
			Card cardDetails, Date orderDate) {
		super();
		this.orderId = orderId;
		this.cartDetails = cartDetails;
		this.userDetails = userDetails;
		this.shippingAddress = shippingAddress;
		this.paymentMethods = paymentMethods;
		this.cardDetails = cardDetails;
		this.orderDate = orderDate;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}

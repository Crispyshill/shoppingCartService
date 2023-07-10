package com.transcendenttopicals.shoppingCartService;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShoppingCart {

	@Id
	private String cartId;
	
	private HashMap<String, Integer> products;
	
	
	public ShoppingCart() {
		
	}
	
	
	
	
	public ShoppingCart(String cartId, HashMap<String, Integer> products) {
		super();
		this.cartId = cartId;
		this.products = products;
	}




	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public HashMap<String, Integer> getProducts() {
		return products;
	}
	public void setProducts(HashMap<String, Integer> products) {
		this.products = products;
	}
	
	
}

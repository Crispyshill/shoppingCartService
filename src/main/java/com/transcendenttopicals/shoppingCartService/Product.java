package com.transcendenttopicals.shoppingCartService;

public class Product {
	private String productId;
	private int inventory;
	
	public Product() {
		
	}

	public Product(String productId, int inventory) {
		super();
		this.productId = productId;
		this.inventory = inventory;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	

}

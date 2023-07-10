package com.transcendenttopicals.shoppingCartService;



import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShoppingCartService {
@Autowired
private ShoppingCartDAO shoppingCartRepository;

	public void addProduct(String cartNumber, String productId) {
		
		Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartNumber);
		if(shoppingCartOptional.isEmpty()) {
			HashMap<String, Integer> products = new HashMap<String, Integer>();
			products.put(productId, 1);
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setProducts(products);
			shoppingCartRepository.save(shoppingCart);
		}
		else {
		ShoppingCart shoppingCart = shoppingCartOptional.get();
		
		if(shoppingCart.getProducts().get(productId) == null) {
			shoppingCart.getProducts().put(productId, 1);
			shoppingCartRepository.save(shoppingCart);
		}
		else {
			shoppingCart.getProducts().put(productId, shoppingCart.getProducts().get(productId));
			shoppingCartRepository.save(shoppingCart);
		}
		}
	}
	
	public void removeProduct(String cartNumber, String productId) {
		Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartNumber);
		ShoppingCart shoppingCart = shoppingCartOptional.get();
		if(shoppingCart.getProducts().get(productId) > 0) {
			shoppingCart.getProducts().put(productId, shoppingCart.getProducts().get(productId)-1);
			shoppingCartRepository.save(shoppingCart);
		}
		else {
			System.out.println("FUCK");
		}
		
	}

	public ShoppingCart getCart(String cartId) {
		Optional<ShoppingCart> shoppingCartOptional = shoppingCartRepository.findById(cartId);
		if(shoppingCartOptional.isEmpty()) {
			return null;
		}
		else {
			return shoppingCartOptional.get();
			}
	}
}

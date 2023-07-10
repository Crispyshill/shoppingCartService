package com.transcendenttopicals.shoppingCartService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ShoppingCartController {
	@Autowired
	ShoppingCartService shoppingCartService;

	@PutMapping("/addDefaultProduct")
	public ResponseEntity<?> addDefaultProduct(){
		shoppingCartService.addProduct("1234", "420");
		return new ResponseEntity<String>("Default product added", HttpStatus.OK);
	}
	
	@PutMapping("/addProduct/{productId}")
	public ResponseEntity<?> addProduct(@RequestBody String cartId, @PathVariable String productId){
		shoppingCartService.addProduct(cartId, productId);
		return new ResponseEntity<String>("Product added", HttpStatus.OK);
	}
	
	@DeleteMapping("/removeProduct/{productId}")
	public ResponseEntity<?> removeProduct(@RequestBody String cartId, @PathVariable String productId){
		shoppingCartService.removeProduct(cartId, productId);
		return new ResponseEntity<String>("Product removed", HttpStatus.OK);
	}
	
	@GetMapping("/getCart/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable String cartId){
		ShoppingCart cart = shoppingCartService.getCart(cartId);
		return new ResponseEntity<ShoppingCart>(cart, HttpStatus.OK);
	}
}


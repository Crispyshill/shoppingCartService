package com.transcendenttopicals.shoppingCartService;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartDAO extends MongoRepository<ShoppingCart, String>{

}

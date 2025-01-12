package com.petstore.ecommerce.cartmanagement.application;

import com.petstore.ecommerce.cartmanagement.domain.Cart;
import com.petstore.ecommerce.cartmanagement.domain.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartManagement {

    public Cart getCart() {
        return new Cart(UUID.randomUUID());
    }

    public Cart getCart(UUID id) {
        return new Cart(id);
    }

    public Cart addProduct(UUID cartId, Product product) {
        Cart cart = getCart(cartId);
        cart.addProduct(product);
        return cart;
    }
}

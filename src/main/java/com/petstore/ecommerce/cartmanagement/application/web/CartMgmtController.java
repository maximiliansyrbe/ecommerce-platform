package com.petstore.ecommerce.cartmanagement.application.web;

import com.petstore.ecommerce.cartmanagement.application.CartManagement;
import com.petstore.ecommerce.cartmanagement.application.web.dto.AddProductRequest;
import com.petstore.ecommerce.cartmanagement.application.web.dto.CartResponse;
import com.petstore.ecommerce.cartmanagement.domain.Cart;
import com.petstore.ecommerce.cartmanagement.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("cart-management/v1")
@RequiredArgsConstructor
public class CartMgmtController {

    private final CartManagement cartManagement;

    @GetMapping(path = "cart", produces = "application/json")
    public CartResponse getCart() {
        Cart cart = cartManagement.getCart();
        return toCartResponse(cart);
    }

    @GetMapping(path = "cart/{cartId}", produces = "application/json")
    public CartResponse getCart(@PathVariable UUID cartId) {
        Cart cart = cartManagement.getCart(cartId);
        return toCartResponse(cart);
    }

    @PostMapping(path = "cart/{cartId}/product", produces = "application/json", consumes = "application/json")
    public CartResponse addProduct(@PathVariable UUID cartId, @RequestBody AddProductRequest request) {
        Cart cart = cartManagement.addProduct(cartId, toProduct(request));
        return toCartResponse(cart);
    }

    private Product toProduct(AddProductRequest request) {
        return new Product(UUID.randomUUID());
    }

    private CartResponse toCartResponse(Cart cart) {
        return new CartResponse(cart.getId());
    }
}

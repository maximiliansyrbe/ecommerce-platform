package com.petstore.ecommerce.cartmanagement.application.web;

import com.petstore.ecommerce.cartmanagement.application.web.dto.CartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("cart-management/v1")
@RequiredArgsConstructor
public class CartMgmtController {

    @GetMapping(path = "cart", produces = "application/json")
    public CartResponse getCart() {
        return new CartResponse(UUID.randomUUID());
    }
}

package com.petstore.ecommerce.cartmanagement.application.web;

import com.petstore.ecommerce.cartmanagement.ReadyForCheckoutEvent;
import com.petstore.ecommerce.cartmanagement.application.web.dto.CartResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("cart-management/v1")
@RequiredArgsConstructor
public class CartMgmtController {

    private final ApplicationEventPublisher publisher;

    @GetMapping(path = "cart", produces = "application/json")
    public CartResponse getCart() {
        return new CartResponse(UUID.randomUUID());
    }

    @GetMapping(path = "cart/{cartId}/checkout", produces = "application/json")
    public void forwardToCheckout(@PathVariable UUID cartId) {
        this.publisher.publishEvent(new ReadyForCheckoutEvent(cartId));
    }
}

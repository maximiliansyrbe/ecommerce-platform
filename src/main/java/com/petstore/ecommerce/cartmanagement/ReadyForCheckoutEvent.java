package com.petstore.ecommerce.cartmanagement;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ReadyForCheckoutEvent {
    private final UUID cartId;
}

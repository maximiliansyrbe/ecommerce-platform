package com.petstore.ecommerce.checkout;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class CheckoutFinished {
    private final UUID cartId;
}

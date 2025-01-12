package com.petstore.ecommerce.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class PaymentSucceeded {
    private final UUID cartId;
}

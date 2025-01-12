package com.petstore.ecommerce.checkout.application.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class PaymentMethodsResponse {
    private final List<String> payments;
}

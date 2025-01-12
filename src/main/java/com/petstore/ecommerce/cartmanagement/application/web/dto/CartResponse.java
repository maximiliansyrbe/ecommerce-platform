package com.petstore.ecommerce.cartmanagement.application.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class CartResponse {
    private final UUID id;
}

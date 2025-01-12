package com.petstore.ecommerce.payment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

import java.util.UUID;

@AggregateRoot
@RequiredArgsConstructor
@Getter
public class PaymentTransaction {
    @Identity
    private final UUID id;
}

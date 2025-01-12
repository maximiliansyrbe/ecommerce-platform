package com.petstore.ecommerce.cartmanagement.domain;

import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Entity;
import org.jmolecules.ddd.annotation.Identity;

import java.util.UUID;

@Entity
@RequiredArgsConstructor
public class Product {
    @Identity
    private final UUID id;
}

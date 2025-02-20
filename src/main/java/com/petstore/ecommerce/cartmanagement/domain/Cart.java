package com.petstore.ecommerce.cartmanagement.domain;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AggregateRoot
@RequiredArgsConstructor
@Getter
public class Cart {
    @Identity
    private final UUID id;

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }
}


package com.petstore.ecommerce.checkout.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.AggregateRoot;
import org.jmolecules.ddd.annotation.Identity;

@AggregateRoot
@RequiredArgsConstructor
@Getter
public class PaymentMethod {
  @Identity
  private final String code;
}

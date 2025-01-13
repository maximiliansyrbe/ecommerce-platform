package com.petstore.ecommerce.payment;

import com.petstore.ecommerce.payment.application.PaymentEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Payment {

  private final PaymentEngine paymentEngine;

  public void startTransaction(UUID cartId) {
    paymentEngine.startTransaction(cartId);
  }
}

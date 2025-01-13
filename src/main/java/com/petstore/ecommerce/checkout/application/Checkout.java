package com.petstore.ecommerce.checkout.application;

import com.petstore.ecommerce.checkout.domain.PaymentMethod;
import com.petstore.ecommerce.payment.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class Checkout {

  private final Payment payment;

  @Transactional(readOnly = true)
  public List<PaymentMethod> getPaymentMethods(String salesOrg) {
    return List.of(new PaymentMethod("PAYPAL"), new PaymentMethod("CREDIT_CARD"));
  }

  @Transactional
  public void invokePayment(UUID cartId) {
    // 1. get Cart
    // 2. validate cart
    payment.startTransaction(cartId);
    // 4. set status to PAID
    // 5. save cart
  }
}

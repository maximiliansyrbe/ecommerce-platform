package com.petstore.ecommerce.ordermanagement.application;

import com.petstore.ecommerce.ordermanagement.OrderPlaced;
import com.petstore.ecommerce.payment.PaymentSucceeded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderManagement {
    private final ApplicationEventPublisher publisher;

    @ApplicationModuleListener
    @Async
    public void on(PaymentSucceeded event) {
      log.info("Placing order for cart {}", event.getCartId());
      // create order here...
      publisher.publishEvent(new OrderPlaced());
    }
}

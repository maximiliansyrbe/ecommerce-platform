package com.petstore.ecommerce.payment.application;

import com.petstore.ecommerce.checkout.CheckoutFinished;
import com.petstore.ecommerce.payment.PaymentSucceeded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class Payment {

    private final ApplicationEventPublisher publisher;

    @ApplicationModuleListener
    public void on(CheckoutFinished event) {
        log.info("Processing payment for cart {}", event.getCartId());
        // add payment logic here...
        publisher.publishEvent(new PaymentSucceeded(event.getCartId()));
    }
}

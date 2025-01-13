package com.petstore.ecommerce.payment.application;

import com.petstore.ecommerce.payment.PaymentSucceeded;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentEngine {

    private final ApplicationEventPublisher publisher;

    public void startTransaction(UUID cartId) {
        log.info("Starting payment transaction for cart {}", cartId);

        publisher.publishEvent(new PaymentSucceeded(cartId));
    }
}

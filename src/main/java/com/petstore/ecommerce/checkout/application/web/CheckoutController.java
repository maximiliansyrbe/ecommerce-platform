package com.petstore.ecommerce.checkout.application.web;

import com.petstore.ecommerce.checkout.CheckoutFinished;
import com.petstore.ecommerce.checkout.application.web.dto.DeliveryAddressRequest;
import com.petstore.ecommerce.checkout.application.web.dto.FulfillmentAddressRequest;
import com.petstore.ecommerce.checkout.application.web.dto.PaymentMethodsResponse;
import com.petstore.ecommerce.checkout.application.web.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("checkout/v1")
@RequiredArgsConstructor
public class CheckoutController {

    private final ApplicationEventPublisher publisher;


    @GetMapping(path = "cart/{cartId}/payment-method",
            produces = "application/json")
    public PaymentMethodsResponse getPaymentTypes(@PathVariable String cartId) {
        return new PaymentMethodsResponse(List.of());
    }

    @RequestMapping(path = "cart/{cartId}/fulfillment-address",
            method = {RequestMethod.POST, RequestMethod.PUT},
            consumes = "application/json",
            produces = "application/json")
    public void addFulfillmentAddress(@PathVariable String cartId, @RequestBody FulfillmentAddressRequest request) {

    }

    @RequestMapping(path = "cart/{cartId}/delivery-address",
            method = {RequestMethod.POST, RequestMethod.PUT},
            consumes = "application/json",
            produces = "application/json")
    public void addFulfillmentAddress(@PathVariable String cartId, @RequestBody DeliveryAddressRequest request) {

    }

    @RequestMapping(path = "cart/{cartId}/payment-method",
            method = {RequestMethod.POST, RequestMethod.PUT},
            consumes = "application/json",
            produces = "application/json")
    public void addPayment(@PathVariable String cartId, @RequestBody PaymentRequest request) {

    }

    @RequestMapping(path = "cart/{cartId}/payment",
            method = {RequestMethod.POST},
            produces = "application/json")
    public void forwardToPayment(@PathVariable UUID cartId) {
        this.publisher.publishEvent(new CheckoutFinished(cartId));

    }
}

package com.petstore.ecommerce.checkout.application.web;

import com.petstore.ecommerce.checkout.application.Checkout;
import com.petstore.ecommerce.checkout.application.web.dto.DeliveryAddressRequest;
import com.petstore.ecommerce.checkout.application.web.dto.FulfillmentAddressRequest;
import com.petstore.ecommerce.checkout.application.web.dto.PaymentMethodsResponse;
import com.petstore.ecommerce.checkout.application.web.dto.PaymentRequest;
import com.petstore.ecommerce.checkout.domain.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("checkout/v1")
@RequiredArgsConstructor
public class CheckoutController {

  private final Checkout checkout;

  @GetMapping(path = "salesOrg/{salesOrg}/payment-method",
          produces = "application/json")
  public PaymentMethodsResponse getPaymentMethods(@PathVariable String salesOrg) {
    List<PaymentMethod> paymentMethods = checkout.getPaymentMethods(salesOrg);
    return toPaymentMethodsResponse(paymentMethods);
  }

  @RequestMapping(path = "cart/{cartId}/fulfillment-address",
          method = {RequestMethod.POST, RequestMethod.PUT},
          consumes = "application/json",
          produces = "application/json")
  public void addFulfillmentAddress(@PathVariable UUID cartId, @RequestBody FulfillmentAddressRequest request) {

  }

  @RequestMapping(path = "cart/{cartId}/delivery-address",
          method = {RequestMethod.POST, RequestMethod.PUT},
          consumes = "application/json",
          produces = "application/json")
  public void addDeliveryAddress(@PathVariable UUID cartId, @RequestBody DeliveryAddressRequest request) {

  }

  @RequestMapping(path = "cart/{cartId}/payment-method",
          method = {RequestMethod.POST, RequestMethod.PUT},
          consumes = "application/json",
          produces = "application/json")
  public void addPayment(@PathVariable UUID cartId, @RequestBody PaymentRequest request) {

  }

  @PostMapping(path = "cart/{cartId}/pay",
          produces = "application/json")
  public void invokePayment(@PathVariable UUID cartId) {
    checkout.invokePayment(cartId);
  }

  private PaymentMethodsResponse toPaymentMethodsResponse(List<PaymentMethod> paymentMethods) {
    return new PaymentMethodsResponse(paymentMethods.stream().map(PaymentMethod::getCode).toList());
  }
}

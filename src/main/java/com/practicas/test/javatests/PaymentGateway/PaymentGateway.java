package com.practicas.test.javatests.PaymentGateway;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}

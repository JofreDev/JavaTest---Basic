package com.practicas.test.javatests.PaymentGateway;

import lombok.Getter;

@Getter
public class PaymentProcessor {

    private final PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){

        PaymentResponse paymentResponse = paymentGateway.requestPayment(new PaymentRequest(amount));
        // enum se puede acceder de manera estatica por defecto
        return paymentResponse.getStatus() == (PaymentResponse.PaymentStatus.OK);
    }


}

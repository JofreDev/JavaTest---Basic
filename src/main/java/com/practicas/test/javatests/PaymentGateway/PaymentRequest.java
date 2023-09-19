package com.practicas.test.javatests.PaymentGateway;

import lombok.Getter;

@Getter
public class PaymentRequest {

    private double amount;

    public PaymentRequest(double amount) {
        this.amount = amount;
    }
}

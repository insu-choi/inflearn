package com.example.productorderservice1.payment;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}

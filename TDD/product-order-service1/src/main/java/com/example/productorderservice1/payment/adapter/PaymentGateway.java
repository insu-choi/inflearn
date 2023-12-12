package com.example.productorderservice1.payment.adapter;


interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}

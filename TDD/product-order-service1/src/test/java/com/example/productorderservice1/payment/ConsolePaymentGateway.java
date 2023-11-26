package com.example.productorderservice1.payment;

public class ConsolePaymentGateway implements PaymentGateway {
    @Override
    public void execute(final int totalPrice, final String cardNumber) {
        System.out.println("결제 완료");
    }
}

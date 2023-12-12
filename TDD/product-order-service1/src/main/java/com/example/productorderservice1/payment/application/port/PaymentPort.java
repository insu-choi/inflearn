package com.example.productorderservice1.payment.application.port;

import com.example.productorderservice1.order.domain.Order;
import com.example.productorderservice1.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long aLong);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}

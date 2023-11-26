package com.example.productorderservice1.payment;

import com.example.productorderservice1.order.Order;

interface PaymentPort {
    Order getOrder(Long aLong);

    void pay(int totalPrice, String cardNumber);

    void save(Payment payment);
}

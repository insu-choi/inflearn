package com.example.productorderservice1.payment;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
class PaymentRepository {
    private Map<Long, Payment> persistance = new HashMap<>();
    private Long sequence = 0L;

    public void save(Payment payment) {
        payment.assignId(++sequence);
        persistance.put(payment.getId(), payment);
    }
}

package com.example.productorderservice1.payment.application.service;

import org.springframework.util.Assert;

public record PaymenetRequest(Long orderId, String cardNumber) {

    public PaymenetRequest {
        Assert.notNull(orderId, "주문 ID는 필수입니다.");
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
    }
}

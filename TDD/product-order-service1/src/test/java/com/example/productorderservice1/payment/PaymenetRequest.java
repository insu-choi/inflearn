package com.example.productorderservice1.payment;

import org.springframework.util.Assert;

record PaymenetRequest(Long orderId, String cardNumber) {

    PaymenetRequest {
        Assert.notNull(orderId, "주문 ID는 필수입니다.");
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
    }
}

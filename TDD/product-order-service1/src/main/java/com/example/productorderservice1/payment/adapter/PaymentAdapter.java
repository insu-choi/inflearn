package com.example.productorderservice1.payment.adapter;

import com.example.productorderservice1.order.domain.Order;
import com.example.productorderservice1.order.adapter.OrderRepository;
import com.example.productorderservice1.payment.domain.Payment;
import com.example.productorderservice1.payment.application.port.PaymentPort;
import org.springframework.stereotype.Component;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
            .orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}

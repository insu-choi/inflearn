package com.example.productorderservice1.order.adapter;

import com.example.productorderservice1.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

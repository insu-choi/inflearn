package com.example.productorderservice1.order.application.port;

import com.example.productorderservice1.order.domain.Order;
import com.example.productorderservice1.product.domain.Product;

public interface OrderPort {
    public Product getProductById(final Long productId);

    public void save(Order order);
}

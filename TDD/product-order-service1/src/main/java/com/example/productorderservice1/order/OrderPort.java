package com.example.productorderservice1.order;

import com.example.productorderservice1.product.Product;

interface OrderPort {
    public Product getProductById(final Long productId);

    public void save(Order order);
}

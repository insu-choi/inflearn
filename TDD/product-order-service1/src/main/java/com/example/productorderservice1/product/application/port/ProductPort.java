package com.example.productorderservice1.product.application.port;

import com.example.productorderservice1.product.domain.Product;

public interface ProductPort {
    void save(final Product product);

    Product getProduct(long productId);

    String getProductName(long productId);
}

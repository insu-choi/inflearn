package com.example.productorderservice1.product;

interface ProductPort {
    void save(final Product product);

    Product getProduct(long productId);

    String getProductName(long productId);
}

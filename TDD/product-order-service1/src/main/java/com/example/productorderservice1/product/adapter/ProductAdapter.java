package com.example.productorderservice1.product.adapter;

import com.example.productorderservice1.product.application.port.ProductPort;
import com.example.productorderservice1.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {
    private final ProductRepository productRepository;

    ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public String getProductName(long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
        return product.getName();
    }
}

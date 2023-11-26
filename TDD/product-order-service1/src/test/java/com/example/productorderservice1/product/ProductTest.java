package com.example.productorderservice1.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void update() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }

    @Test
    void noneDiscountedProduct() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        final int discountedPrice = product.getDiscountPrice();

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void fix1000DiscountedProduct() {
        final Product product = new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT);

        final int discountedPrice = product.getDiscountPrice();

        assertThat(discountedPrice).isEqualTo(1000);
    }
}
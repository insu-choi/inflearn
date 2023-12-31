package com.example.productorderservice1.product.application.service;

import com.example.productorderservice1.product.GetProductResponse1;
import com.example.productorderservice1.product.domain.Product;
import com.example.productorderservice1.product.application.port.ProductPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public
class ProductService {
    private final ProductPort productPort;

    ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
        final Product product = new Product(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable long productId) {
        final Product product = productPort.getProduct(productId);

        final GetProductResponse response = new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscountPolicy());
        return ResponseEntity.ok(response);
    }

    public GetProductResponse1 getProductName(long productId) {
        final String name = productPort.getProductName(productId);

        return new GetProductResponse1(name);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(@PathVariable final Long productId, @RequestBody final UpdateProductRequest request) {
        final Product product = productPort.getProduct(productId);
        product.update(request.name(), request.price(), request.discountPolicy());
        productPort.save(product);
        return ResponseEntity.ok().build();
    }


}

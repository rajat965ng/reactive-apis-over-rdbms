package com.product.app.service;

import com.product.app.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    public Mono<Product> save(Product product);
    public Mono<Product> getProductById(Long id);
    public Flux<Product> getAllProducts();
}

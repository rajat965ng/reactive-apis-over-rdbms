package com.product.app.service;

import com.product.app.entity.Product;
import com.product.app.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

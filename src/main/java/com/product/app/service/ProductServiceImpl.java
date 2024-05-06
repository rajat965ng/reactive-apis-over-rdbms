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
    private GenAIService genAIService;

    public ProductServiceImpl(ProductRepository productRepository, GenAIService genAIService) {
        this.productRepository = productRepository;
        this.genAIService = genAIService;
    }

    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(product).map(p -> p.withAugmentedDescription(genAIService.generateAugmentedDescription(p.toString())));
    }

    @Override
    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id).map(p -> p.withAugmentedDescription(genAIService.generateAugmentedDescription(p.toString())));
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }
}

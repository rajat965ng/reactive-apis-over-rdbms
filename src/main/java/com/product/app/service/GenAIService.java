package com.product.app.service;

import org.springframework.ai.chat.ChatResponse;
import reactor.core.publisher.Flux;

public interface GenAIService {
    public String generateAugmentedDescription(String message);
}

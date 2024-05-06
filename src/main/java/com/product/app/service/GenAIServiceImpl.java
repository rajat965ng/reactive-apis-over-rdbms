package com.product.app.service;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.stereotype.Service;

@Service
public class GenAIServiceImpl implements GenAIService {
    private final OpenAiChatClient chatClient;

    public GenAIServiceImpl(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String generateAugmentedDescription(String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }
}

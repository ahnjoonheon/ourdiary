package com.example.ourdiary.message;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageSourceAccessor messageSource;

    public MessageService(MessageSourceAccessor messageSource) {
        this.messageSource = messageSource;
    }

    public String get(String code, String... args) {
        return messageSource.getMessage(code, args);
    }
}

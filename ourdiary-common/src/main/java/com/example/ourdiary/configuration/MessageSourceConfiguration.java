package com.example.ourdiary.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfiguration {

    @Bean
    public MessageSource messageSource() {
        return new ReloadableResourceBundleMessageSource();
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor(ReloadableResourceBundleMessageSource messageSource) {
        return new MessageSourceAccessor(messageSource);
    }
}

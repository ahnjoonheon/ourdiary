package com.example.ourdiary.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class LocalDateTimeEditor extends PropertyEditorSupport {
    @Value("${ourdiary.date-time-format}")
    private String dateTimeFormat;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null && !text.isEmpty()) {
            LocalDateTime dateTime = LocalDateTime.parse(text, DateTimeFormatter.ofPattern(dateTimeFormat));
            setValue(dateTime);
        } else {
            setValue(null);
        }
    }
}



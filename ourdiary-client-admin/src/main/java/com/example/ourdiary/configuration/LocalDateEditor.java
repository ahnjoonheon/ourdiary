package com.example.ourdiary.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class LocalDateEditor extends PropertyEditorSupport {
    @Value("${ourdiary.date-format}")
    private String dateFormat;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null && !text.isEmpty()) {
            LocalDate dateTime = LocalDate.parse(text, DateTimeFormatter.ofPattern(dateFormat));
            setValue(dateTime);
        } else {
            setValue(null);
        }
    }
}

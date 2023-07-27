package com.example.ourdiary.configuration;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeEditor extends PropertyEditorSupport {
    private final String pattern;

    public LocalDateTimeEditor(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null && !text.isEmpty()) {
            LocalDateTime dateTime = LocalDateTime.parse(text, DateTimeFormatter.ofPattern(pattern));
            setValue(dateTime);
        } else {
            setValue(null);
        }
    }
}



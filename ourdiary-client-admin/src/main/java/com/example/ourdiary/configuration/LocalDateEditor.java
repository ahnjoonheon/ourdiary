package com.example.ourdiary.configuration;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateEditor extends PropertyEditorSupport {
    private final String pattern;

    public LocalDateEditor(String pattern) {
        this.pattern = pattern;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text != null && !text.isEmpty()) {
            LocalDate dateTime = LocalDate.parse(text, DateTimeFormatter.ofPattern(pattern));
            setValue(dateTime);
        } else {
            setValue(null);
        }
    }
}

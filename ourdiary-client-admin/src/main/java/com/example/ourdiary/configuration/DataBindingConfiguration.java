package com.example.ourdiary.configuration;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class for handling data binding such as
 * <br>{@link org.springframework.web.bind.annotation.RequestBody},
 * <br>{@link org.springframework.web.bind.annotation.PathVariable},
 * <br>{@link org.springframework.web.bind.annotation.RequestParam}
 */
@ControllerAdvice
public class DataBindingConfiguration {
    private final LocalDateTimeEditor localDateTimeEditor;
    private final LocalDateEditor localDateEditor;

    public DataBindingConfiguration(LocalDateTimeEditor localDateTimeEditor, LocalDateEditor localDateEditor) {
        this.localDateTimeEditor = localDateTimeEditor;
        this.localDateEditor = localDateEditor;
    }

    /**
     * convert empty string to null or trim string
     * @param dataBinder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        dataBinder.registerCustomEditor(LocalDateTime.class, localDateTimeEditor);
        dataBinder.registerCustomEditor(LocalDate.class, localDateEditor);
    }
}
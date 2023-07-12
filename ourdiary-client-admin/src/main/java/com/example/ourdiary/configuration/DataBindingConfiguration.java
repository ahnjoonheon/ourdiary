package com.example.ourdiary.configuration;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Class for handling data binding such as
 * <br>{@link org.springframework.web.bind.annotation.RequestBody},
 * <br>{@link org.springframework.web.bind.annotation.PathVariable},
 * <br>{@link org.springframework.web.bind.annotation.RequestParam}
 */
@ControllerAdvice
public class DataBindingConfiguration {

    /**
     * convert empty string to null or trim string
     * @param dataBinder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
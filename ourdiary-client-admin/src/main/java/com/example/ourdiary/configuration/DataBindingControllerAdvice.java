package com.example.ourdiary.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for handling data binding such as
 * <br>{@link org.springframework.web.bind.annotation.RequestBody},
 * <br>{@link org.springframework.web.bind.annotation.PathVariable},
 * <br>{@link org.springframework.web.bind.annotation.RequestParam}
 */
@ControllerAdvice
public class DataBindingControllerAdvice {

    @Value("${ourdiary.date-format}")
    private String datePattern;

    @Value("${ourdiary.date-time-format}")
    private String dateTimePattern;

//    public DataBindingControllerAdvice(MappingJackson2HttpMessageConverter converter) {
//        List<MediaType> supportedMediaTypes = new ArrayList<>(converter.getSupportedMediaTypes());
//        supportedMediaTypes.add(new MediaType("application", "octet-stream"));
//        converter.setSupportedMediaTypes(supportedMediaTypes);
//    }

    /**
     * convert empty string to null or trim string
     * @param dataBinder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        dataBinder.registerCustomEditor(LocalDateTime.class, new LocalDateTimeEditor(dateTimePattern));
        dataBinder.registerCustomEditor(LocalDate.class, new LocalDateEditor(datePattern));
    }

    /**
     * Bind Data which is request body
     * @return ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimePattern)));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimePattern)));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(datePattern)));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(datePattern)));

        return Jackson2ObjectMapperBuilder.json()
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .modules(module)
                .build();
    }


}
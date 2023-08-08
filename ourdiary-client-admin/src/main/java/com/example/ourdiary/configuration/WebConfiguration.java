package com.example.ourdiary.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
                List<MediaType> supportedMediaTypes = new ArrayList<>(mappingJackson2HttpMessageConverter.getSupportedMediaTypes());
                supportedMediaTypes.add(new MediaType("application", "octet-stream"));
                mappingJackson2HttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
            }
        }
    }

    @Profile("local")
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:///C:/work/ourdiary/file/");
    }

}

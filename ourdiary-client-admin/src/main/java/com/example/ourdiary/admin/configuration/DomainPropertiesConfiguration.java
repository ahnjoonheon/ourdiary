package com.example.ourdiary.admin.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-domain.properties")
public class DomainPropertiesConfiguration {
}

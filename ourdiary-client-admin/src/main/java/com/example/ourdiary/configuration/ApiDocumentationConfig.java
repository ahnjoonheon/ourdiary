package com.example.ourdiary.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocumentationConfig {

    @Bean
    public OpenAPI openAPI() {

        Info info = new Info().title("Ourdiary Admin API Docs").version("v1")
                .description("ourdiary admin api docs")
//                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact().name("AJ").email("universal304015@gmail.com"))
//                .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"))
                ;

        return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("BearerAuth"))
                .components(
                        new Components().addSecuritySchemes("BearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                )
                .info(info);
    }
}

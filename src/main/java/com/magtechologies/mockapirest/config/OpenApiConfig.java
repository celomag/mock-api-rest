package com.magtechologies.mockapirest.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mock Service API")
                        .description("API para servir como mock service para testes")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Team")
                                .email("team@example.com")));
    }
}
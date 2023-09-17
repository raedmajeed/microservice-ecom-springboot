package com.raedmajeed.orderservice.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Builder;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("")
                .packagesToScan()
                .build();
    }

    @Bean
    public OpenAPI openAPIO() {
        return new OpenAPI().info(
                new Info()
                        .license(new License().name("Amazon 2020"))
                        .description("Order-Service API")
                        .contact(new Contact().name("Raed Abdul Majeed"))
        );
    }
}

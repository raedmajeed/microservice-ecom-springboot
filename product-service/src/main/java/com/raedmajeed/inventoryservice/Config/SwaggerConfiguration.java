package com.raedmajeed.inventoryservice.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi api()
    {
        return GroupedOpenApi.builder()
                .group("ProductController")
                .packagesToScan("com.raedmajeed.productservice.Controller")
                .build();
    }
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Product Creation API")
                        .description("Spring shop sample application")
                        .version("v0.0.1")
                        .contact(new Contact().name("Raed"))
                        .description("Product Add API Documentation")
                        .license(new License().name("HERO"))
                );
    }
}

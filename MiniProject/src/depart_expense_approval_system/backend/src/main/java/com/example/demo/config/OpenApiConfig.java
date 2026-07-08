package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Department Expense Approval System API")
                        .version("1.0.0")
                        .description("API Documentation for Department Expense Approval System detailing endpoints, validation models, and transactional schemas.")
                        .contact(new Contact()
                                .name("Enterprise Software Team")
                                .email("support@company.com")));
    }
}
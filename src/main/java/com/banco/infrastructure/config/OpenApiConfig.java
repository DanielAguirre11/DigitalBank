package com.banco.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema Bancario Digital - API REST")
                        .description("API REST para la gestion de clientes, cuentas y transacciones bancarias.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Sistema Bancario Digital")
                                .email("soporte@banco.com")));
    }
}

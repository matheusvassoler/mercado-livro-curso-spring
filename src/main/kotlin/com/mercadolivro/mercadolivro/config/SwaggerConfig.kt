package com.mercadolivro.mercadolivro.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("!prod")
@Configuration
class SwaggerConfig {

    @Bean
    fun springApi(): OpenAPI = OpenAPI()
        .info(Info().title("Documentacao Mercado Livro")
            .description("Documentacao explicativa"))
}
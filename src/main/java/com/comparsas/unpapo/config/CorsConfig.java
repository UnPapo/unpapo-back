package com.comparsas.unpapo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir CORS para todos os domínios e todos os métodos HTTP
        registry.addMapping("/**")
                .allowedOrigins("*") // Liberar para qualquer domínio
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Liberar todos os cabeçalhos
                .allowCredentials(true); // Permitir credenciais, se necessário
    }
}
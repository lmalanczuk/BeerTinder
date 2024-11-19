package com.bt.beertinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Zezwala na dostęp do endpointów API
                .allowedOrigins("http://localhost:4200")  // Dozwolona aplikacja frontendowa
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Dozwolone metody HTTP
                .allowedHeaders("*")  // Zezwala na wszystkie nagłówki
                .allowCredentials(true);  // Zezwala na uwierzytelnianie (np. cookies)
    }
}


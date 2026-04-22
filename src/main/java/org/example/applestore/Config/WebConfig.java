package org.example.applestore.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

    @Configuration
    public class WebConfig implements WebMvcConfigurer {

        @Value("${app.cors.allowed-origin-patterns:${app.cors.allowed-origins:http://localhost:*,http://127.0.0.1:*,http://192.168.*:*,http://10.*:*}}")
        private List<String> allowedOriginPatterns;

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedOriginPatterns(allowedOriginPatterns.toArray(new String[0]))
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .maxAge(36000000);
        }
    }

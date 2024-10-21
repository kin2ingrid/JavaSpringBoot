package com.master.projet.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests -> authorizeRequests
                .anyRequest().permitAll() // Autorise toutes les requêtes
            )
            .csrf(csrf -> csrf.disable()); // Désactive CSRF uniquement si nécessaire pour le développement
        return http.build();
    }
}

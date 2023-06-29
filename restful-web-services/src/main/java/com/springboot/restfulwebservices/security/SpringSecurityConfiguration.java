package com.springboot.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(
                        auth -> auth.anyRequest().authenticated()
                );
        httpSecurity.httpBasic(
                Customizer.withDefaults()
        );

        httpSecurity
                .csrf(
                        AbstractHttpConfigurer::disable
                );

        return httpSecurity.build();
    }
}

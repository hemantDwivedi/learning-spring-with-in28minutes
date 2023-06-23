package com.example.springboot.todomanagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    // LDAP OR Database
    // InMemory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){
        UserDetails userDetails1 = createNewUser("hemant", "12345");
        UserDetails userDetails2 = createNewUser("krishna", "123");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User
                .builder()
                .passwordEncoder(
                        passwordEncoder
                )
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }


    // All URLs are protected
    // a login form is shown for unauthorized requests
    // CSRF needs to disable
    // Frames

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        authorization -> authorization.anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults()); // enable form login, all defaults that are associated with form login

        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(
                        headers ->
                                headers
                                        .frameOptions(Customizer.withDefaults()).disable()
                );

        return http.build();
    }

}
package com.example.learnoauth;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/")
    public String hello(Authentication authentication){
        System.out.println(authentication);
        System.out.println(authentication.getPrincipal());
        return "hello world";
    }
}

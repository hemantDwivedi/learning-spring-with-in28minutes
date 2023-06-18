package com.example.springboot.todomanagement.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name, String password){
        boolean isValidUsername = name.equals("hemant");
        boolean isValidPassword = password.equals("123");

        return isValidUsername && isValidPassword;
    }
}

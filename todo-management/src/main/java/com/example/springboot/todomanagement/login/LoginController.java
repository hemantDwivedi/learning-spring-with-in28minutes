package com.example.springboot.todomanagement.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    // http:localhost:8080/login?name=something
    @RequestMapping("login")
    public String loginPage() {
        return "login";
    }
}

package com.example.springboot.todomanagement.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // http:localhost:8080/login?name=something
    @RequestMapping("login")
    public String loginPage(@RequestParam String name, @RequestParam String username, @RequestParam String password,
                            ModelMap model) {
        model.put("name", name);
        model.put("username", username);
        model.put("password", password);
        return "login";
    }
}

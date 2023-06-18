package com.example.springboot.todomanagement.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // http:localhost:8080/login?name=something
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name,
                              @RequestParam String password,
                              ModelMap model){
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
}

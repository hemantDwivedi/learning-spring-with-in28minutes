package com.example.springboot.todomanagement.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // http:localhost:8080/login?name=something
    @RequestMapping("login")
    public String loginPage(@RequestParam String name, @RequestParam String username, @RequestParam String password,
                            ModelMap model) {
        model.put("name", name);
        model.put("username", username);
        model.put("password", password);

        logger.debug("First request param is {}", name);
        logger.debug("Second request param is {}", username);
        logger.debug("Third request param is {}", password);
        return "login";
    }
}

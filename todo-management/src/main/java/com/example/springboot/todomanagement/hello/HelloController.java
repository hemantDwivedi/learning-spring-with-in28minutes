package com.example.springboot.todomanagement.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @RequestMapping("hello")
    @ResponseBody
    public String Hello(){
        return "Hello!";
    }

    @RequestMapping("hello-html")
    @ResponseBody
    public String HelloHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Hello html page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("this is html page say hello");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("hello-jsp")
    public String helloJsp(){
        return "sayHelloJsp";
    }
}

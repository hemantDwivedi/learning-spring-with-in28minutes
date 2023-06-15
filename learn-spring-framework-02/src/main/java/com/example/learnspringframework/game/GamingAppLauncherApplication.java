package com.example.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example.learnspringframework.game")
public class GamingAppLauncherApplication {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)
                ){
            context.getBean(GameRunner.class).run();
        }
    }
}

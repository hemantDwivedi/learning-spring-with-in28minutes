package com.example.learnspringframework;

import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App02GamingBasicJava {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)
                ){
            // context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}

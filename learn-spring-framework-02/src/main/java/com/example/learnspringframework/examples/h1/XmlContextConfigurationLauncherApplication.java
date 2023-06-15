package com.example.learnspringframework.examples.h1;

import com.example.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan
public class XmlContextConfigurationLauncherApplication {
    public static void main(String[] args) {
        try(
                var context =
                        new ClassPathXmlApplicationContext("contextConfiguration.xml")
                ){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("game"));
            context.getBean(GameRunner.class).run();
        }
    }
}

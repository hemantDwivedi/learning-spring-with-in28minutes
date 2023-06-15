package com.example.learnspringframework;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SimpleClass {
    private DependencyClass dependencyClass;

    public SimpleClass(DependencyClass dependencyClass) {
        this.dependencyClass = dependencyClass;
    }

    @PostConstruct
    public void initialize() {
        dependencyClass.start();
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("system cleanUP");
    }
}

@Component
class DependencyClass {
    public void start() {
        System.out.println("Some logic using DependencyClass");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args) {
        try (
                var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)
        ) {
        }
    }
}

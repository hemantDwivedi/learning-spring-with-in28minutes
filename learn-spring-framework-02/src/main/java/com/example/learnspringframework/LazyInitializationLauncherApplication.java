package com.example.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA){
        // logic
        System.out.println("Some logic executing...");
        this.classA = classA;
    }

    public void classBMethod(){
        System.out.println("hello class b");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)
                ){
            System.out.println("Initializing of context in completed");
            context.getBean(ClassB.class).classBMethod();
        }
    }
}

package com.example.learnspringframework;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Component
class NormalClass{

}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class)
                ){
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}

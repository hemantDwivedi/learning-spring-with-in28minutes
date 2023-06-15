package com.example.learnspringframework.hellospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppHelloSpring {
    public static void main(String[] args) {

        // 1: Launch a Spring Context
        try (var context = new AnnotationConfigApplicationContext(HelloSpringConfiguration.class)) {

            // 2: configure the things that we want Spring to manage = @Configuration
            // HelloSpringConfiguration - @Configuration
            // name - @Bean

            // 3: Retrieving the Bean managed by Spring
            System.out.println(context.getBean("name")); // 1: By Bean name
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2"));
            System.out.println(context.getBean("person3"));
            System.out.println(context.getBean("person4Parameters"));
            System.out.println(context.getBean("person5Parameters"));
            System.out.println(context.getBean("address3"));
            System.out.println(context.getBean(Address.class)); // 2: By class name or type

        // list all beans managed by Spring
//        Arrays
//                .stream(
//                        context.getBeanDefinitionNames()
//                )
//                .forEach(
//                        System.out::println
//                );
        }
    }
}

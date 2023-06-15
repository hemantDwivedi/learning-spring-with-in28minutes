package com.example.learnspringframework.hellospring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age, Address address){};
record Address(String city, String state){};
@Configuration
public class HelloSpringConfiguration {
    @Bean
    public String name(){
        return "Hemant";
    }

    @Bean
    public int age(){
        return 24;
    }

    @Bean
    public Person person(){
        return new Person("bubu", 25, new Address("Kesaria", "Bihar"));
    }

    @Bean(name = "person2")
    public Person person2MethodCall(){
        return new Person(name(), age(), address()); //name, age, address
    }

    @Bean(name = "person3")
    public Person person3Parameters(String name, int age, Address address2){
        return new Person(name, age, address2); //name, age, address
    }

    @Bean
    public Person person4Parameters(String name, int age, Address address){
        return new Person(name, age, address); //name, age, address
    }

    @Bean
    public Person person5Parameters(String name, int age,@Qualifier("address3Qualifier") Address address){
        return new Person(name, age, address); //name, age, address
    }

    @Bean(name = "address2")
    @Primary
    public Address address(){
        return new Address("Kesaria", "Bihar");
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier")
    public Address address3(){
        return new Address("Gurgaon", "Haryana");
    }
}

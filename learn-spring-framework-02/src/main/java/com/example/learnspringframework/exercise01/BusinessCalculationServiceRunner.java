package com.example.learnspringframework.exercise01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;


//@Component
@Repository
class BusinessCalculationService{
    private final DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays
                .stream(dataService.retrieveDate())
                .max()
                .orElse(0);
    }
}

@Configuration
@ComponentScan
public class BusinessCalculationServiceRunner {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(BusinessCalculationServiceRunner.class)
                ){
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }

}

package com.example.learnspringframework;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named
class BusinessService{
    private DataService1 dataService;

    public DataService1 getDataService() {
        return dataService;
    }

//    @Autowired
    @Inject
    public void setDataService(DataService1 dataService) {
        System.out.println("setter injection");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService1{

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {
        try(
                var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)
                ){
            Arrays
                    .stream(
                            context.getBeanDefinitionNames()
                    )
                    .forEach(
                            System.out::println
                    );
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}

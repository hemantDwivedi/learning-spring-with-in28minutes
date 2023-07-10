package com.example.learnspringaop.aopexample.business;

import com.example.learnspringaop.aopexample.data.DataService1;
import com.example.learnspringaop.aopexample.data.DataService2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService2 {
    public BusinessService2(DataService2 dataService2) {
        this.dataService2 = dataService2;
    }

    private DataService2 dataService2;

    public int calculateMin() throws InterruptedException {
        int[] data = dataService2.retrieveData();
        Thread.sleep(30);
//        throw new RuntimeException("something went wrong");
        return Arrays
                .stream(data)
                .min()
                .orElse(0);
    }
}

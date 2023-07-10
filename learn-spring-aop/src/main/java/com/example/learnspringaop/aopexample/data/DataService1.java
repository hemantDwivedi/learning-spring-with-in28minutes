package com.example.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
    public int[] retrieveData() throws InterruptedException {
        Thread.sleep(30);
        return new int[]{1, 2, 3, 4, 5};
    }
}

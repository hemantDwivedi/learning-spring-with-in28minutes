package com.example.learnspringaop.aopexample.data;

import com.example.learnspringaop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {
    @TrackTime
    public int[] retrieveData() throws InterruptedException {
        Thread.sleep(30);
        return new int[]{12,34,56,12,464,23,33,9,1};
    }
}

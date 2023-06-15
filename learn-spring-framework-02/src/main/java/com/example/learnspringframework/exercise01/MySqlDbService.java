package com.example.learnspringframework.exercise01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySqlDbService implements DataService {
    @Override
    public int[] retrieveDate() {
        return new int[]{11, 22, 33, 44, 55};
    }
}

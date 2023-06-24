package com.springboot.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1, "Sam", LocalDate.now().minusYears(20)));
        users.add(new User(2, "Hemant", LocalDate.now().minusYears(218)));
        users.add(new User(3, "Tim", LocalDate.now().minusYears(40)));
    }

    public List<User> findAll(){
        return users;
    }
}

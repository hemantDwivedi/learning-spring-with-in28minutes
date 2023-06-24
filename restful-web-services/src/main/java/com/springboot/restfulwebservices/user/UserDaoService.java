package com.springboot.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static {
        users.add(new User(++usersCount, "Sam", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount, "Hemant", LocalDate.now().minusYears(218)));
        users.add(new User(++usersCount, "Tim", LocalDate.now().minusYears(40)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users
                .stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

    public void save(User user){
        user.setId(++usersCount);
        users.add(user);
    }
}

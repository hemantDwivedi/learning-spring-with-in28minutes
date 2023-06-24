package com.springboot.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    private final UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable Integer id) {
        return service.findOne(id);
    }
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        service.save(user);
    }

}

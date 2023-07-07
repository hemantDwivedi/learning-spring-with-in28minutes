package com.example.learnsprinsecurity.resources;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    public static final List<Todo> TODOS = List.of(
            new Todo("hemant", "learn spring security"),
            new Todo("hemant", "learn Google cloud")
    );

    @GetMapping("/todos")
    public List<Todo> retrieveTodo() {
        return TODOS;
    }

    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'hemant'")
    @RolesAllowed({"ADMIN", "USER"})
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public Todo retrieveTodoForSpecificUser(@PathVariable String username) {
        return TODOS.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@RequestBody Todo todo, @PathVariable String username){
        logger.info("Create {} for {}", todo, username);
    }
}

record Todo(String username, String description) {}
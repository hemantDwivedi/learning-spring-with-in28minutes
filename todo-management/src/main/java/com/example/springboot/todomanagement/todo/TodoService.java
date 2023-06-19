package com.example.springboot.todomanagement.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    private static List<Todo> todos;
    static {
        todos.add(new Todo(
                1,
                "Hemant",
                "Learn Spring Boot 3",
                LocalDate.now().plusYears(1),
                false
        ));
        todos.add(new Todo(
                1,
                "Sam",
                "Learn AWS",
                LocalDate.now().plusYears(2),
                false
        ));
        todos.add(new Todo(
                1,
                "Sara",
                "Learn Microsoft Azure",
                LocalDate.now().plusYears(1),
                false
        ));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}

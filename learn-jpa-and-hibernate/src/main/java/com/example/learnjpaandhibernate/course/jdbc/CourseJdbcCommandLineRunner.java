package com.example.learnjpaandhibernate.course.jdbc;

import com.example.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insertQuery(new Course(1, "Spring Boot", "Spring Doc"));
        repository.insertQuery(new Course(2, "DevOps", "xyz"));
        repository.insertQuery(new Course(3, "AWS", "xyz2"));
        repository.deleteQuery(2);
    }
}
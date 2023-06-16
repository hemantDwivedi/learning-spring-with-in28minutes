package com.example.learnjpaandhibernate.course;

import com.example.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Spring Boot", "Spring Doc"));
        repository.insert(new Course(2, "DevOps", "xyz"));
        repository.insert(new Course(3, "AWS", "xyz2"));
        repository.deleteById(2);
        System.out.println(repository.findById(1));
        System.out.println(repository.findById(3));
    }
}
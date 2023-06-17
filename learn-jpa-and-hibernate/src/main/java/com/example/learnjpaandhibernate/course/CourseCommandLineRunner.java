package com.example.learnjpaandhibernate.course;

import com.example.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
//        Using CourseJdbcRepository
//        repository.insert(new Course(1, "Spring Boot", "Spring Doc"));
//        repository.insert(new Course(2, "DevOps", "xyz"));
//        repository.insert(new Course(3, "AWS", "xyz2"));
//        repository.deleteById(2);
//        System.out.println(repository.findById(1));
//        System.out.println(repository.findById(3));


        // Using CourseSpringDataJpaRepository
        repository.save(new Course(1, "Spring Boot", "Spring Doc"));
        repository.save(new Course(2, "DevOps", "xyz"));
        repository.save(new Course(3, "AWS", "xyz2"));
        repository.deleteById(2L);
        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findAll()); // print all entity that are present in database
        System.out.println(repository.count()); // print number of entity
        System.out.println(repository.findByAuthor("Spring Doc")); // find the entity by 'author' and print it
        System.out.println(repository.findByName("Spring Boot")); // find the entity by 'course name' and print it

    }
}
package com.example.startspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BasicController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "Learn spring boot", "xyz1"),
                new Course(2, "Learn cloud", "xyz2"),
                new Course(3, "Learn AWS", "xyz3")
        );
    }
}

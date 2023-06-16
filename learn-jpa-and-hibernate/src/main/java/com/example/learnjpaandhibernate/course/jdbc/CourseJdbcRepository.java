package com.example.learnjpaandhibernate.course.jdbc;

import com.example.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                    INSERT INTO course (id, name, author)
                    VALUES(?, ?,?);
                    
            """;
    private static String DELETE_QUERY =
            """
                    DELETE FROM course
                    WHERE id=?;

            """;
    public void insertQuery(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteQuery(long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
}

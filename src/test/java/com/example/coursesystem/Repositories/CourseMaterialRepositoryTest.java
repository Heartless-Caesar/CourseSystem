package com.example.coursesystem.Repositories;

import com.example.coursesystem.Entities.Course;
import com.example.coursesystem.Entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .courseName("Python 101")
                .courseCredit(10)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("string1")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }
}
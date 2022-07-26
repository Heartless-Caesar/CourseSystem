package com.example.coursesystem.Repositories;

import com.example.coursesystem.Entities.Guardian;
import com.example.coursesystem.Entities.Student;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
        Guardian guardian = Guardian.builder()
                .email("email1@example.com")
                .mobile("999999999")
                .name("Guardian1")
                .build();

        Student student = Student.builder()
                .studentId(1L)
                .firstName("Julius")
                .lastName("Caesar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentEmbeddedGuardian(){
        Guardian guardian = Guardian.builder()
                .email("email1@example.com")
                .mobile("999999999")
                .name("Guardian1")
                .build();

        Student student = Student.builder()
                .studentId(1L)
                .firstName("Julius")
                .lastName("Caesar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findStudentByFirstName(){
       List<Student> students = studentRepository.findByFirstName("Julius");

        System.out.println("Students " + students);
    }


    @Test
    public void findStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("ius");

        System.out.println("Students " + students);
    }

    @Test
    public void findStudentGuardianName(){
        List<Student> students = studentRepository.findByGuardianNameContaining("dian1");

        System.out.println("Students " + students);
    }


    @Test
    public void getStudentFirstNameByIdJPAQuery(){
        String student = studentRepository.getStudentFirstNameById(1L);

        System.out.println("Students " + student);
    }

    @Test
    public void getStudentFirstNameByIdJPAQueryNative(){
        List<Student> student = studentRepository.getStudentByIdNative(1L);

        System.out.println("Students " + student);
    }

    @Test
    public void getStudentByFirstNameParam(){
        List<Student> student = studentRepository.getStudentByFirstNameParam("Julius");

        System.out.println("Students " + student);
    }

    @Test
    public void updateStudentFirstNameByGuardianEmail(){
        studentRepository.updateStudentByGuardianEmail("Matthew","guardian2@email.com");
    }
}
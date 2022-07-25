package com.example.coursesystem.Repositories;

import com.example.coursesystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String studentName);

    public List<Student> findByGuardianNameContaining(String guardianName);

    public List<Student> findByFirstNameContaining(String studentName);


    //JPQL
    @Query(value = "SELECT s FROM Student s WHERE s.studentId = ?1")
    public List<Student> getStudentById(String studentId);
}

package com.example.coursesystem.Repositories;

import com.example.coursesystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String studentName);

    public List<Student> findByGuardianNameContaining(String guardianName);

    public List<Student> findByFirstNameContaining(String studentName);


    //JPQL
    @Query(value = "SELECT s.firstName FROM Student s WHERE s.studentId = ?1")
    public String getStudentFirstNameById(Long studentId);

    //Native query
    @Query(value = "SELECT * FROM student s WHERE s.student_id = ?1", nativeQuery = true)
    public List<Student> getStudentByIdNative(Long studentId);

    //Native query with named param
    @Query(value = "SELECT * FROM student s WHERE s.first_name = :firstName", nativeQuery = true)
    public List<Student> getStudentByFirstNameParam(@Param("firstName") String studentFirstName);



}

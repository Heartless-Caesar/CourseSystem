package com.example.coursesystem.Repositories;

import com.example.coursesystem.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

    //Transactional annotation so you can alter data in the database
    @Modifying
    @Transactional
    @Query(value = "UPDATE student SET first_name = ?1 WHERE guardian_email = ?2",nativeQuery = true)
    public int updateStudentByGuardianEmail(String firstName,String guardianEmail);
}

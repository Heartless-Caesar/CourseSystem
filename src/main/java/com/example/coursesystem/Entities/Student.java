package com.example.coursesystem.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "studentSequence", sequenceName = "studentSequence", allocationSize = 1)
    private Long studentId;


    private String firstName;

    private String lastName;

    //private String emailId;
}

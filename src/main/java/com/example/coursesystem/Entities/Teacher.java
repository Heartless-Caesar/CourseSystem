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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "teacherSequence", sequenceName = "teacherSequence", allocationSize = 1)
    private Long guardianId;

    private String firstName;

    private String lastName;
}

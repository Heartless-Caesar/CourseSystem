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
    @SequenceGenerator(name = "studentSequence", sequenceName = "studentSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentSequence")
    private Long studentId;

    private String firstName;

    private String lastName;

    @Embedded
    private Guardian guardian;
}

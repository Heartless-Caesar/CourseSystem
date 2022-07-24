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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "courseSequence", sequenceName = "courseSequence", allocationSize = 1)
    private Long courseId;

    private String courseName;

    private int courseCredit;
}

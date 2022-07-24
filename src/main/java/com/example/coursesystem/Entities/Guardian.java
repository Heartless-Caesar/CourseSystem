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
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "guardianSequence", sequenceName = "guardianSequence", allocationSize = 1)
    private Long guardianId;

    private String name;

    private String email;

    private String mobile;
}

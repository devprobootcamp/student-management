package com.devprobootcamp.student_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String title;

    @ManyToOne()
    private StudentEntity students;

}

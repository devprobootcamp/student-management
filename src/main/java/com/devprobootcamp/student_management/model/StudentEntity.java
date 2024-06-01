package com.devprobootcamp.student_management.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String studentPassword;
    private LocalDate dob;

    @OneToMany(mappedBy = "students")
    private List<CourseEntity> courses;
}

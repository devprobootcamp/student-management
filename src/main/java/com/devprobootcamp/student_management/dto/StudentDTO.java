package com.devprobootcamp.student_management.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDTO {

    private String name;
    private LocalDate dob;

    List<CourseDTO> courses;
}

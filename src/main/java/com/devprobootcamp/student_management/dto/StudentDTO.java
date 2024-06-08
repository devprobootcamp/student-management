package com.devprobootcamp.student_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class StudentDTO {


    @NotBlank(message = "Name is missing")
    @Size(min = 5, max = 20, message = "Name must be between 5-20 chars")
    private String name;

    @NotNull(message = "DOB is missing")
    private LocalDate dob;

    @NotNull(message = "Course can not be null")
    @Size(min = 1, message = "Course must be provided")
    private List<CourseDTO> courses;
}

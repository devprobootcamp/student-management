package com.devprobootcamp.student_management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentInfoDTO {
    private String name;
    private LocalDate dob;
}

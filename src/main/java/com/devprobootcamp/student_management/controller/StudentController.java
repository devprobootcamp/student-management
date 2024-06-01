package com.devprobootcamp.student_management.controller;

import com.devprobootcamp.student_management.dto.StudentDTO;
import com.devprobootcamp.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping()
    public ResponseEntity<Void> addStudentAndCourse( @RequestBody StudentDTO studentDTO){
        studentService.addStudent(studentDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search-student")
    public ResponseEntity<List<StudentDTO>> addStudentAndCourse(@RequestParam String code){
        return ResponseEntity.ok(studentService.searchStudent(code));
    }

}

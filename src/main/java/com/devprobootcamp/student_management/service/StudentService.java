package com.devprobootcamp.student_management.service;

import com.devprobootcamp.student_management.dto.CourseDTO;
import com.devprobootcamp.student_management.dto.StudentDTO;
import com.devprobootcamp.student_management.model.CourseEntity;
import com.devprobootcamp.student_management.model.StudentEntity;
import com.devprobootcamp.student_management.repository.CourseRepository;
import com.devprobootcamp.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void addStudent(StudentDTO studentDTO) {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setDob(studentDTO.getDob());
        studentEntity.setName(studentDTO.getName());
        studentEntity.setStudentPassword("ABC");
        StudentEntity savedStudent = studentRepository.save(studentEntity);

        for (CourseDTO courseDTO : studentDTO.getCourses()) {
            CourseEntity courseEntity = new CourseEntity();
            courseEntity.setCode(courseDTO.getCode());
            courseEntity.setTitle(courseDTO.getTitle());
            courseEntity.setStudents(savedStudent);
            courseRepository.save(courseEntity);
        }


    }

    public List<StudentDTO> searchStudent(String code) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<StudentEntity> studentEntities = studentRepository.searchStudentByCode(code);
        for (StudentEntity st : studentEntities) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(st.getName());
            studentDTO.setDob(st.getDob());
            studentDTOS.add(studentDTO);
            List<CourseDTO> courseDTOS = new ArrayList<>();
            for (CourseEntity c : st.getCourses()) {
                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setCode(c.getCode());
                courseDTO.setTitle(c.getTitle());
                courseDTOS.add(courseDTO);
            }
            studentDTO.setCourses(courseDTOS);
        }
        return studentDTOS;
    }
}

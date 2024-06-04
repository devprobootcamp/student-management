package com.devprobootcamp.student_management;

import com.devprobootcamp.student_management.dto.CourseDTO;
import com.devprobootcamp.student_management.model.CourseEntity;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CourseEntity courseEntity1 = new CourseEntity();
        courseEntity1.setId("000000001");
        courseEntity1.setCode("CS001");
        courseEntity1.setTitle("Computer Science");

        CourseEntity courseEntity2 = new CourseEntity();
        courseEntity2.setId("000000002");
        courseEntity2.setCode("CS002");
        courseEntity2.setTitle("Advanced Computer Science");

        List<CourseEntity> courses = new ArrayList<>();
        courses.add(courseEntity1);
        courses.add(courseEntity2);

        System.out.println(courses);

        List<CourseDTO> courseDTOS = new ArrayList<>();

        for(CourseEntity course: courses){
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCode(course.getCode());
            courseDTO.setTitle(course.getTitle());
            courseDTOS.add(courseDTO);
        }

        System.out.println(courseDTOS);
    }
}

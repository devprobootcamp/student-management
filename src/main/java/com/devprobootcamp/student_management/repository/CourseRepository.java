package com.devprobootcamp.student_management.repository;

import com.devprobootcamp.student_management.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {
}

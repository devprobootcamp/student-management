package com.devprobootcamp.student_management.repository;

import com.devprobootcamp.student_management.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

//    select * from students, courses where students.id = courses.students_id AND `courses`.`code` = 'CS103';
    @Query("SELECT s FROM StudentEntity s JOIN s.courses c WHERE c.code =:cd")
    List<StudentEntity> searchStudentByCode(@Param("cd") String code);
}

package com.example.demo.mapper;

import com.example.demo.dto.EnrollmentDto;
import com.example.demo.entity_model.Course;
import com.example.demo.entity_model.Enrollment;
import com.example.demo.entity_model.Student;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {
public EnrollmentDto toDto (Enrollment enrollment){
    return new EnrollmentDto(
            enrollment.getId(),
            enrollment.getStudent().getId(),
            enrollment.getCourse().getId(),
            enrollment.getGrade()
    );
}
public Enrollment toEntity(EnrollmentDto enrollmentDto, Student student, Course course){
    return new Enrollment(
            student,
            course,
            enrollmentDto.getGrade()
    );
}
}

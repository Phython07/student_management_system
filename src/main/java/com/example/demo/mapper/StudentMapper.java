package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity_model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto toDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getIdNo(),
                student.getName(),
                student.getAge(),
                student.getGender()
        );
    }

    public Student toEntity(StudentDto studentDto) {
    return new Student(
            studentDto.getIdNo(),
            studentDto.getName(),
            studentDto.getAge(),
            studentDto.getGender()
    );
    }
}

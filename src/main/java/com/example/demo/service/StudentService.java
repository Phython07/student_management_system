package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity_model.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.StudentRepo;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    // Create a new student
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        Student savedStudent = studentRepo.save(student);
        return studentMapper.toDto(savedStudent);
    }

    // Get student by ID
    public StudentDto getStudentById(Long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return studentMapper.toDto(student);
    }

    // Get all students
    public List<StudentDto> getAllStudents() {
        return studentRepo.findAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    // Update student
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        existingStudent.setIdNo(studentDto.getIdNo());
        existingStudent.setName(studentDto.getName());
        existingStudent.setAge(studentDto.getAge());
        existingStudent.setGender(studentDto.getGender());

        Student updatedStudent = studentRepo.save(existingStudent);
        return studentMapper.toDto(updatedStudent);
    }

    // Delete student
    public void deleteStudent(Long id) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        studentRepo.delete(existingStudent);
    }
}

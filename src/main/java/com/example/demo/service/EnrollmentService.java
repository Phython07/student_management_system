package com.example.demo.service;

import com.example.demo.dto.EnrollmentDto;
import com.example.demo.entity_model.Course;
import com.example.demo.entity_model.Enrollment;
import com.example.demo.entity_model.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.EnrollmentRepo;
import com.example.demo.repo.StudentRepo;
import com.example.demo.repo.CourseRepo;
import com.example.demo.mapper.EnrollmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {

    private final EnrollmentRepo enrollmentRepo;
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final EnrollmentMapper enrollmentMapper;

    @Autowired
    public EnrollmentService(EnrollmentRepo enrollmentRepo, StudentRepo studentRepo,
                             CourseRepo courseRepo, EnrollmentMapper enrollmentMapper) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.enrollmentMapper = enrollmentMapper;
    }

    // Create a new enrollment
    public EnrollmentDto createEnrollment(EnrollmentDto enrollmentDto) {
        // Fetch student and course by their respective IDs
        Student student = studentRepo.findById(enrollmentDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepo.findById(enrollmentDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Enrollment enrollment = new Enrollment(student, course, enrollmentDto.getGrade());
        Enrollment savedEnrollment = enrollmentRepo.save(enrollment);
        return enrollmentMapper.toDto(savedEnrollment);
    }

    // Get all enrollments
    public List<EnrollmentDto> getAllEnrollments() {
        return enrollmentRepo.findAll().stream()
                .map(enrollmentMapper::toDto)
                .collect(Collectors.toList());
    }

    // Get enrollments by student ID
    public List<EnrollmentDto> getEnrollmentsByStudentId(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepo.findByStudentId(studentId);
        return enrollments.stream()
                .map(enrollmentMapper::toDto)
                .collect(Collectors.toList());
    }

    // Update enrollment (e.g., update grade)
    public EnrollmentDto updateEnrollment(Long id, EnrollmentDto enrollmentDto) {
        Enrollment existingEnrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));

        // Update the fields with the values from enrollmentDto
        Student student = studentRepo.findById(enrollmentDto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepo.findById(enrollmentDto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        existingEnrollment.setGrade(enrollmentDto.getGrade());
        existingEnrollment.setStudent(student);
        existingEnrollment.setCourse(course);

        Enrollment updatedEnrollment = enrollmentRepo.save(existingEnrollment);
        return enrollmentMapper.toDto(updatedEnrollment);
    }


    // Delete an enrollment
    public void deleteEnrollment(Long id) {
        Enrollment existingEnrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        enrollmentRepo.delete(existingEnrollment);
    }

    // Get an enrollment by its ID
    public EnrollmentDto getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));
        return enrollmentMapper.toDto(enrollment);
    }

}


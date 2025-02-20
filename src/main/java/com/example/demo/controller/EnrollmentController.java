package com.example.demo.controller;

import com.example.demo.dto.EnrollmentDto;
import com.example.demo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // Create a new enrollment
    @PostMapping
    public ResponseEntity<EnrollmentDto> createEnrollment(@RequestBody EnrollmentDto enrollmentDto) {
        EnrollmentDto savedEnrollment = enrollmentService.createEnrollment(enrollmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrollment);
    }

    // Get an enrollment by its ID
    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDto> getEnrollment(@PathVariable Long id) {
        EnrollmentDto enrollment = enrollmentService.getEnrollmentById(id);
        return ResponseEntity.ok(enrollment);
    }

    // Update an existing enrollment
    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDto> updateEnrollment(@PathVariable Long id, @RequestBody EnrollmentDto enrollmentDto) {
        EnrollmentDto updatedEnrollment = enrollmentService.updateEnrollment(id, enrollmentDto);
        return ResponseEntity.ok(updatedEnrollment);
    }

    // Delete an enrollment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

    // Get all enrollments
    @GetMapping
    public ResponseEntity<List<EnrollmentDto>> getAllEnrollments() {
        List<EnrollmentDto> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }
}

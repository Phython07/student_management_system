package com.example.demo.repo;

import com.example.demo.entity_model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long studentId);


}

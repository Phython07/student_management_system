package com.example.demo.repo;

import com.example.demo.entity_model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
}

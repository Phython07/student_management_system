package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity_model.Course;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.CourseRepo;
import com.example.demo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseRepo courseRepo, CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

    // Create a new course
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        Course savedCourse = courseRepo.save(course);
        return courseMapper.toDto(savedCourse);
    }

    // Get course by ID
    public CourseDto getCourseById(Long id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return courseMapper.toDto(course);
    }

    // Get all courses
    public List<CourseDto> getAllCourses() {
        return courseRepo.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    // Update course
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        existingCourse.setName(courseDto.getName());
        existingCourse.setCourseCode(courseDto.getCourseCode());

        Course updatedCourse = courseRepo.save(existingCourse);
        return courseMapper.toDto(updatedCourse);
    }

    // Delete course
    public void deleteCourse(Long id) {
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        courseRepo.delete(existingCourse);
    }
}

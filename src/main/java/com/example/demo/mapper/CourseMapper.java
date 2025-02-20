package com.example.demo.mapper;


import com.example.demo.dto.CourseDto;
import com.example.demo.entity_model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDto toDto(Course course){
        return new CourseDto(
                course.getId(),
                course.getName(),
                course.getCourseCode());
    }


    public Course toEntity(CourseDto courseDto){
        return new Course(courseDto.getName(),
                courseDto.getCourseCode());
    }

}

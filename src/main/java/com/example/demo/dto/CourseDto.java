package com.example.demo.dto;

public class CourseDto {

    private Long id;
    private String name;
    private String courseCode;


    public CourseDto(Long id, String name, String courseCode) {
        this.name = name;
        this.courseCode = courseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}

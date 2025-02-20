package com.example.demo.dto;

public class EnrollmentDto {

    private Long studentId;
    private Long courseId;
    private String grade;

    public EnrollmentDto(Long id, Long studentId, Long courseId, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "EnrollmentDto{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade='" + grade + '\'' +
                '}';
    }
}

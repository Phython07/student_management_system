package com.example.demo.dto;

public class StudentDto {
    private Long id;
    private Long idNo;
    private String name;
    private int age;
    private String gender;


    public StudentDto() {
    }

    public StudentDto(Long id, Long idNo, String name, int age, String gender) {
        this.idNo = idNo;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", idNo=" + idNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

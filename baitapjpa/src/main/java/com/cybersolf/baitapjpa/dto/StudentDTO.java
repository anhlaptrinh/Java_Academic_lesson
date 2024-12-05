package com.cybersolf.baitapjpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class StudentDTO {
    private int id;
    private String studentName;
    private String studentEmail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String courseRegistration;
    public StudentDTO() {
    }

    public StudentDTO(int id, String studentName, String studentEmail, String courseRegistration) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.courseRegistration = courseRegistration;
    }

    public StudentDTO(int id, String studentName, String studentEmail) {
        this.id = id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getCourseRegistration() {
        return courseRegistration;
    }

    public void setCourseRegistration(String courseRegistration) {
        this.courseRegistration = courseRegistration;
    }
}

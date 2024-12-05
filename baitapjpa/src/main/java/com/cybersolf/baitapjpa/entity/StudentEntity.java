package com.cybersolf.baitapjpa.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String studentName;
    @Column(name = "email")
    private String studentEmail;
    @Column(name = "age")
    private int studentAge;
    @ManyToMany
    @JoinTable(name = "registration",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<CoursesEntity> courses;
    public StudentEntity() {

    }

    public StudentEntity(String studentName, String studentEmail, int studentAge) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentAge = studentAge;
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

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public Set<CoursesEntity> getCourses() {
        return courses;
    }

    public void setCourses(Set<CoursesEntity> courses) {
        this.courses = courses;
    }
}

package com.cybersolf.baitapjpa.dto;

public class CourseDTO {
    private int courseId;
    private String courseTitle;
    private int courseDuration;

    public CourseDTO() {
    }

    public CourseDTO(int courseId, String courseTitle, int courseDuration) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDuration = courseDuration;

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }


}

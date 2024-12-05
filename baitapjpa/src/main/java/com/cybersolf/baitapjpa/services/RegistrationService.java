package com.cybersolf.baitapjpa.services;

import com.cybersolf.baitapjpa.dto.CourseDTO;
import com.cybersolf.baitapjpa.dto.StudentDTO;
import com.cybersolf.baitapjpa.entity.CoursesEntity;
import com.cybersolf.baitapjpa.entity.StudentEntity;
import com.cybersolf.baitapjpa.repository.CoursesRepository;
import com.cybersolf.baitapjpa.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegistrationService {
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    public String insertAllCourse(int id){
        StudentEntity student = studentsRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

        List<CoursesEntity> courses = coursesRepository.findAll();
        Set<CoursesEntity> existingCourses = student.getCourses();
        courses.forEach(course -> {
            if (!existingCourses.contains(course)) {
                existingCourses.add(course);
            }
        });
        student.setCourses(existingCourses);
        studentsRepository.save(student);

        return "add all courses successfully";
    }

    public Set<CourseDTO> findCoursesByStudent(int id){
        StudentEntity student = studentsRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));


        return student.getCourses().stream().map(course->new CourseDTO(course.getId(),course.getTitle(),course.getDuration())).collect(Collectors.toSet());
    }

    public List<StudentDTO> findStudentByCourse(int id){
        CoursesEntity courses = coursesRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        String courseName= courses.getTitle();
        return courses.getStudents()
                .stream()
                .map(student -> new StudentDTO(student.getId(),student.getStudentName(),student.getStudentEmail(),courseName))
                .collect(Collectors.toList());
    }

    public String deleteCourse(int studentId, int courseId) {
        CoursesEntity courses = coursesRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        StudentEntity student = studentsRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        if (student.getCourses().contains(courses)) {
            student.getCourses().remove(courses);
            studentsRepository.save(student); // Lưu lại thay đổi
            return "Course removed successfully";
        } else {
            return "The student is not registered in this course";
        }

    }
    public String postStudentToCourse(int studentId, int courseId) {
        StudentEntity student = studentsRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Lấy thông tin khóa học
        CoursesEntity course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        if (student.getCourses().contains(course)) {
            return "Student is already registered in this course";
        }


        student.getCourses().add(course);
        studentsRepository.save(student);

        return "Student added to course successfully";

    }
}

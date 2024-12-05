package com.cybersolf.baitapjpa.controller;

import com.cybersolf.baitapjpa.dto.StudentDTO;
import com.cybersolf.baitapjpa.entity.StudentEntity;
import com.cybersolf.baitapjpa.services.RegistrationService;
import com.cybersolf.baitapjpa.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/students")
public class StudentController {
    private final StudentsService studentsService;
    @Autowired
    public StudentController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }
    @Autowired
    private RegistrationService registrationService;
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestParam int age, @RequestParam String email, @RequestParam String name){
        if(studentsService.insertStudent(age,email,name)!=null){
            return ResponseEntity.ok("Student added successfully");
        }
        return ResponseEntity.ofNullable("Student added failed");


    }
    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        return ResponseEntity.ok(studentsService.getStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        return ResponseEntity.ok(studentsService.getStudentById(id));


    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody StudentEntity updatedStudent){
        studentsService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(studentsService.updateStudent(id, updatedStudent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){

        return ResponseEntity.ok(studentsService.deleteById(id));
    }

    @PostMapping("/{id}/courses")
    public ResponseEntity<?> insertCourse(@PathVariable int id){
        return ResponseEntity.ok(registrationService.insertAllCourse(id));
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getCourseByStudentId(@PathVariable int id){
        return ResponseEntity.ok(registrationService.findCoursesByStudent(id));
    }

    @PostMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<?> postCourseByStudentId(@PathVariable int studentId, @PathVariable int courseId){

        return ResponseEntity.ok(registrationService.postStudentToCourse(studentId, courseId));
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<?> deleteCourseByStudentId(@PathVariable int studentId, @PathVariable int courseId){
        return ResponseEntity.ok(registrationService.deleteCourse(studentId, courseId));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getStudentByStudentId(@RequestParam(required = false) String name, @RequestParam(required = false) Integer ageFrom, @RequestParam(required = false) Integer ageTo, Pageable pageable){
        Page<StudentDTO> studentPage =  studentsService.searchStudent(name, ageFrom, ageTo, pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("data", studentPage.getContent());
        response.put("currentPage", studentPage.getNumber());
        response.put("totalItems", studentPage.getTotalElements());
        response.put("totalPages", studentPage.getTotalPages());
        return ResponseEntity.ok(response);
    }
}

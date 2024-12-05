package com.cybersolf.baitapjpa.controller;

import com.cybersolf.baitapjpa.dto.CourseDTO;
import com.cybersolf.baitapjpa.services.CoursesServices;
import com.cybersolf.baitapjpa.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/courses")
public class CourseController {
    @Autowired
    private CoursesServices coursesServices;
    @Autowired
    private RegistrationService registrationService;


    @GetMapping
    public ResponseEntity<?> getDurationsGreaterThanHours(@RequestParam int durationGreaterThan) {

        return ResponseEntity.ok(coursesServices.getDurationGreateThanHours(durationGreaterThan).isEmpty() ? "Do not have a duration greater" : coursesServices.getDurationGreateThanHours(durationGreaterThan));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByKeyWords(@RequestParam String name) {
        return ResponseEntity.ok(coursesServices.getCourseByName(name));
    }

    @GetMapping("/count")
    public ResponseEntity<?> countCourses() {
        return ResponseEntity.ok(coursesServices.getCountCourse());
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<?> getStudentByCourseId(@PathVariable int id) {
        return ResponseEntity.ok(registrationService.findStudentByCourse(id));
    }

    @GetMapping("/pagination")
    public ResponseEntity<?> getCoursePages(Pageable pageable) {
        Page<CourseDTO> coursePage
                = coursesServices.getCoursePage(pageable);
        Map<String, Object> response = new HashMap<>();
        response.put("data", coursePage
                .getContent());
        response.put("currentPage", coursePage
                .getNumber());
        response.put("totalItems", coursePage
                .getTotalElements());
        response.put("totalPages", coursePage
                .getTotalPages());
        return ResponseEntity.ok(response);
    }

}

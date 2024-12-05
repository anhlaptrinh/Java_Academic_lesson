package com.cybersolf.studenthomework.controller;

import com.cybersolf.studenthomework.model.StudentEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final List<StudentEntity> students=new ArrayList<StudentEntity>();

    @PostMapping("/addByParams")
    public ResponseEntity<?> postStudentByRequestParam(@RequestParam String name, @RequestParam int age){
        students.add(new StudentEntity(name, age));
        return ResponseEntity.ok(students);
    }

    @PostMapping("/addByPathVariable/{name}/{age}")
    public ResponseEntity<?> postStudentByPathVariable(@PathVariable String name,@PathVariable int age){
        students.add(new StudentEntity(name,age));
        return ResponseEntity.ok(students);
    }

    @PostMapping("/addByRequestBody")
    public ResponseEntity<?> postStudentByRequestBody(@RequestBody StudentEntity student){
        students.add(new StudentEntity(student.getName(),student.getAge()));
        return ResponseEntity.ok(students);
    }

}

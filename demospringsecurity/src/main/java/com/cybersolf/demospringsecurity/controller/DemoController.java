package com.cybersolf.demospringsecurity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Value("${cybersolf.username}")
    private String username;
    @GetMapping
    public ResponseEntity<?> demo(){
        return ResponseEntity.ok(username);
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok("Hello World 2");
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(){
        return ResponseEntity.ok("add Product");
    }

}

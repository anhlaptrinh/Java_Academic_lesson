package com.cybersolf.demojwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok("get All Product");
    }
    @PostMapping("/insert")
    public ResponseEntity<?> insertProduct(){
        return ResponseEntity.ok("insert Product");
    }
}

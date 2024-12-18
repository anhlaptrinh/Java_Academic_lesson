package com.cybersolf.demospringsecurity.controller;

import com.cybersolf.demospringsecurity.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private UserModel user;

    @GetMapping
    public ResponseEntity<?> getProduct(){
        return ResponseEntity.ok("get product");
    }
}

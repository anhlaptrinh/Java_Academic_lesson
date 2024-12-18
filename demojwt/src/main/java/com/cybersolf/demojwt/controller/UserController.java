package com.cybersolf.demojwt.controller;


import com.cybersolf.demojwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> getUser(@RequestParam("email") String email, @RequestParam("password") String password){

        return ResponseEntity.ok(userService.getUserEntity(email, password));
    }
}

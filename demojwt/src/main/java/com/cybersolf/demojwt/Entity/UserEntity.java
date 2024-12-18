package com.cybersolf.demojwt.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "role_id")
    private int roleId;
}

package com.cybersolf.demojwt.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}

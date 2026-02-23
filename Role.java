package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;
}


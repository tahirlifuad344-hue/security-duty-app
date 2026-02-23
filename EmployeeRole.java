package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "employee_roles")
@Setter
public class EmployeeRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}


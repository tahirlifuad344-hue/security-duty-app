package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "duty_templates")
@Setter
public class DutyTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "is_active")
    private Boolean isActive = true;
}

package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_unavailability")
@Setter
public class EmployeeUnavailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee_unavailability;

    private String reason;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    private String note;

    private LocalDateTime createdAt = LocalDateTime.now();
}

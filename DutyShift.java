package com.example.security.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "duty_shifts")
@Setter
public class DutyShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "template_id")
    private DutyTemplate template;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    private LocalDateTime createdAt = LocalDateTime.now();
}

